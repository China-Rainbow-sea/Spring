package com.rainbowsea.spring6.service;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 代替spring.xml 文件
@ComponentScan(value = {"com.rainbowsea.spring6.service"})  // 组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true) // 启用 aspectj的自动代理机制
public class Spring6Config {

}
