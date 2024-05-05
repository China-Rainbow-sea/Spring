package com.rainbowsea.reflect;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.rainbowsea.reflect.sprint.bean","com.rainbowsea.reflect.sprint.dao"})
public class Spring6Configuration {
}
