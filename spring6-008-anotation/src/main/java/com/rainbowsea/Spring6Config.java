package com.rainbowsea;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 编写一个列，代替Spring 框架的配置文件
 */
@Configuration
@ComponentScan(value = {"com.rainbowsea.dao","com.rainbowsea.service"})
public class Spring6Config {

}
