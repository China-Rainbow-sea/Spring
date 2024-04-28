# Bean的生命周期按照粗略的五步的话:

> 1. 第一步: 实例化Bean (调用无参数构成方法)
> 2. 第二步: 给Bean属性赋值(调用set方法)
> 3. 第三步: 初始化Bean (会调用Bean的init()方法，注意：这个 init()方法需要自己写，自己配)
> 4. 第四步：使用Bean
> 5. 第五步：销毁Bean(会调用Bean的destroy()方法，注意：这个destroy()方法需要自己写，自己配)

# Bean 生命周期七步，比五步添加的那两步在哪里？在初始化Bean的前和后

> 1. 第一步:实例化Bean(调用无参数构造方法)
> 2. 第二步:给Bean(属性赋值，调用 set 方法)
> 3. 第三步:执行Bean 后处理器的“before” 方法 ("初始化 Bean的前一步执行: implements BeanPostProcessor postProcessBeforeInitialization()的方法 ")
> 4. 第四步:初始化Bean
> 5. 第五步:执行Bean后处理器的 “after” 方法 ("初始化 Bean的后一步执行: implements BeanPostProcessor  postProcessAfterInitialization()的方法")
> 6. 第六步:使用Bean
> 7. 第七步:销毁Bean


# Bean生命周期十步: 比七步添加的那三步在哪里，在 Bean初始化前面的：Bean处理器当中的BeanPostProcessor类中的postProcessBeforeInitialization()方法行。前后
> 1. 第一步:实例化Bean(调用无参数构造方法)
> 2. 第二步:给Bean(属性赋值，调用 set 方法)
> 3. 第三步: Bean是否实现了Aware的相关接口是什么意思？ Aware相关的接口包括：BeanNameAware、BeanClassLoaderAware、BeanFactoryAware
> 4. 第四步:执行Bean 后处理器的“before” 方法 ("初始化 Bean的前一步执行: implements BeanPostProcessor postProcessBeforeInitialization()的方法 ")
> 5. 第五步：检查Bean是否实现了InitializingBean 接口，并调用接口方法
> 6. 第六步:初始化Bean
> 7. 第七步:执行Bean后处理器的 “after” 方法 ("初始化 Bean的后一步执行: implements BeanPostProcessor  postProcessAfterInitialization()的方法")
> 8. 第八步:使用Bean
> 9. 第九步: 检查 Bean是否实现了DisposableBean接口，并调用接口方法
> 10. 第十步:销毁Bean