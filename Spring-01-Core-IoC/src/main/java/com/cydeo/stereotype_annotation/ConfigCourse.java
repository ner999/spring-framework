package com.cydeo.stereotype_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
@ComponentScan(basePackages = "com.cydeo")
public class ConfigCourse {


}
