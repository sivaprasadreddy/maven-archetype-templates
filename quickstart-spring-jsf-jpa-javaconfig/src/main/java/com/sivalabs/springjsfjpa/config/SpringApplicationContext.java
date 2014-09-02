/**
*
*
*/
package com.sivalabs.springjsfjpa.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware{
    
    private static ApplicationContext springContext;
    
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        springContext = ctx;        
    }
    
    public static <T> T getBean(Class<T> clazz)
    {
        return springContext.getBean(clazz);
    }

}
