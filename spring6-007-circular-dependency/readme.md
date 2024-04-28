# Bean的循环依赖问题
> **singleton + setter模式下的循环依赖** 
> singleton表示在整个Spring容器当中十单例的，独一无二的对象
> 在singleton + setter 模式下，为什么循环依赖不会出现问题，Spring是如何应对的？
> 主要原因是，在这个模式下Spring对Bean管理主要分为清晰的两个阶段
> 第一个阶段：在Spring容器加载的时候，实例Bean，只要其中任意一个Bean实例化之后，马上进行“曝光”（不等属性赋值就曝光）
> 第二阶段: Bean"曝光" 之后，再进行属性的赋值（调用set方法()）
> 核心解决方案是：实例化对象和对象的属性赋值分为两个阶段来完成的。


>**在 prototype + setter模式下的循环依赖**
>BeanCreationException 报错：当前的Bean正在处于创建中异常
> 注意：当两个bean的scope都是prototype的时候，才会出现异常，如果其中任意一个是singleton的，就不会出现异常了。-->
> 就不会出现异常了。
>是其中的任意一个就行。
> 因为：singleton 优先被“曝光”，实例化和赋值是分开的。


> **基于构造注入（进行赋值）**，很明显，要调用构造方法进行赋值，所以会产生循环依赖并且无法解决的，
所以编写代码时一定要注意。同样是报：  BeanCreationException 报错：当前的Bean正在处于创建中异常


# 源码解析
> AbstractAutowireCapableBeanFactory 类
> 下的：doCreateBean() 方法
>```java
    protected Object doCreateBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
    throws BeanCreationException {

		// Instantiate the bean.
		BeanWrapper instanceWrapper = null;
		if (mbd.isSingleton()) {
			instanceWrapper = this.factoryBeanInstanceCache.remove(beanName);
		}
		if (instanceWrapper == null) {
			instanceWrapper = createBeanInstance(beanName, mbd, args);
		}
		Object bean = instanceWrapper.getWrappedInstance();
		Class<?> beanType = instanceWrapper.getWrappedClass();
		if (beanType != NullBean.class) {
			mbd.resolvedTargetType = beanType;
		}

		// Allow post-processors to modify the merged bean definition.
		synchronized (mbd.postProcessingLock) {
			if (!mbd.postProcessed) {
				try {
					applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
				}
				catch (Throwable ex) {
					throw new BeanCreationException(mbd.getResourceDescription(), beanName,
							"Post-processing of merged bean definition failed", ex);
				}
				mbd.markAsPostProcessed();
			}
		}

		// Eagerly cache singletons to be able to resolve circular references
		// even when triggered by lifecycle interfaces like BeanFactoryAware.
		boolean earlySingletonExposure = (mbd.isSingleton() && this.allowCircularReferences &&
				isSingletonCurrentlyInCreation(beanName));
		if (earlySingletonExposure) {
			if (logger.isTraceEnabled()) {
				logger.trace("Eagerly caching bean '" + beanName +
						"' to allow for resolving potential circular references");
			}
			addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, mbd, bean));
		}

		// Initialize the bean instance.
		Object exposedObject = bean;
		try {
			populateBean(beanName, mbd, instanceWrapper);
			exposedObject = initializeBean(beanName, exposedObject, mbd);
		}
		catch (Throwable ex) {
			if (ex instanceof BeanCreationException bce && beanName.equals(bce.getBeanName())) {
				throw bce;
			}
			else {
				throw new BeanCreationException(mbd.getResourceDescription(), beanName, ex.getMessage(), ex);
			}
		}

		if (earlySingletonExposure) {
			Object earlySingletonReference = getSingleton(beanName, false);
			if (earlySingletonReference != null) {
				if (exposedObject == bean) {
					exposedObject = earlySingletonReference;
				}
				else if (!this.allowRawInjectionDespiteWrapping && hasDependentBean(beanName)) {
					String[] dependentBeans = getDependentBeans(beanName);
					Set<String> actualDependentBeans = new LinkedHashSet<>(dependentBeans.length);
					for (String dependentBean : dependentBeans) {
						if (!removeSingletonIfCreatedForTypeCheckOnly(dependentBean)) {
							actualDependentBeans.add(dependentBean);
						}
					}
					if (!actualDependentBeans.isEmpty()) {
						throw new BeanCurrentlyInCreationException(beanName,
								"Bean with name '" + beanName + "' has been injected into other beans [" +
								StringUtils.collectionToCommaDelimitedString(actualDependentBeans) +
								"] in its raw version as part of a circular reference, but has eventually been " +
								"wrapped. This means that said other beans do not use the final version of the " +
								"bean. This is often the result of over-eager type matching - consider using " +
								"'getBeanNamesForType' with the 'allowEagerInit' flag turned off, for example.");
					}
				}
			}
		}

		// Register bean as disposable.
		try {
			registerDisposableBeanIfNecessary(beanName, bean, mbd);
		}
		catch (BeanDefinitionValidationException ex) {
			throw new BeanCreationException(
					mbd.getResourceDescription(), beanName, "Invalid destruction signature", ex);
		}

		return exposedObject;
	}
``


private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256); 一级缓存
private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16); 二级缓存
private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16); 三级缓存
> 这个三个缓存都是Map集合
> Map集合的key 存储的都是bean的name(bean id)
> 
> 一级缓存存储的是：单例Bean对象，完整的单例Bean对象，也就是这个缓存中的Bean对象的属性都已经赋值了，是一个完整的Bean对象
> 二级缓存存储的是: 早期的案例Bean对象，这个缓存中的单例Bean对象的属性灭有赋值，只是一个早期的实例对象
> 三级缓存促成你的是: 单例工厂对象，这个里面存储了大力的“工厂对象”，每一个单例Bean对象都会对应一个单例工厂对象。
> 这个集合中存储的是，创建该单例对象时对应的那个单例工厂对象。
