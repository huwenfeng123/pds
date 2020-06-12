
package com.zhihuisystem.pds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfiguration {

//	@Bean
//	public Validator validator() {
//		// hibernate.validator.fail_fast：true 快速失败返回模式 false 普通模式
//		ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
//				.configure()
//				.addProperty("hibernate.validator.fail_fast", "true")
//				.buildValidatorFactory();
//		Validator validator = validatorFactory.getValidator();
//		return validator;
//	}

	public ResourceBundleMessageSource getMessageSource() throws Exception {
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setDefaultEncoding("UTF-8");
		rbms.setBasenames("messages");
//		rbms.setBasenames("classpath*:i18n/MessageResources*.properties",
//				"classpath*:MessageResources*.properties",
//				"classpath*:META-INF/MessageResources*.properties");
		return rbms;
	}

	@Bean
	public LocalValidatorFactoryBean validators() throws Exception {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(getMessageSource());
		return localValidatorFactoryBean;
	}

	// @Bean
	// public HttpMessageConverters customConverters() {
	// 	Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	// 	GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
	// 	messageConverters.add(gsonHttpMessageConverter);
	// 	return new HttpMessageConverters(true, messageConverters);
	// }
}
