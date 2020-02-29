package com.example.errorhandling.configs;

import com.example.errorhandling.exception.message.UserMessageResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessageConfig {
    @Bean
    public MessageSource userMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message/user-message");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Bean
    public MessageSourceAccessor userMessageSourceAccessor() {
        return new MessageSourceAccessor(userMessageSource());
    }

    @Bean
    public UserMessageResolver userMessageResolver() {
        return new UserMessageResolver(userMessageSourceAccessor());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(userMessageSource());

        return bean;
    }
}
