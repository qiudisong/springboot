package com.example.demo.config;

import com.example.demo.config.converter.Jackson2DateConverter;
import com.example.demo.config.converter.String2DateConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

@Configuration
public class ConverterConfig {
    @Bean
    public Jackson2DateConverter dateJacksonConverter() {
        return new Jackson2DateConverter();
    }

    @Bean
    public Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean(
            @Autowired Jackson2DateConverter jackson2DateConverter) {
        Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean = new Jackson2ObjectMapperFactoryBean();

        jackson2ObjectMapperFactoryBean.setDeserializers(jackson2DateConverter);
        return jackson2ObjectMapperFactoryBean;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(
            @Autowired ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
                new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2HttpMessageConverter;
    }

    // 处理器映射器(接口适配)
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    /**
     * 此方法解决前台提交的日期参数绑定不正确问题,将自己实现的StringToDateConverter交给spring,让其知道如何进行处理
     */
    @PostConstruct // @PostContruct是java的注解，该注解被用来修饰一个非静态的void（）方法,在方法上加该注解会在项目启动的时候执行该方法，也可以理解为在spring容器初始化的时候执行该方法。
    public void initEditableValidation() {
        // 获取web初始化对象
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
            // 添加自定义的转换器
            genericConversionService.addConverter(new String2DateConverter());
        }
    }
}