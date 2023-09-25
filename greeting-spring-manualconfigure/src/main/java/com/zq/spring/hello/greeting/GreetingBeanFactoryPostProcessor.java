package com.zq.spring.hello.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ClassUtils;

@Slf4j
public class GreetingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		boolean hasClass = ClassUtils.isPresent("com.zq.spring.hello.greeting.SpringGreetingApplicationRunner",
				GreetingBeanFactoryPostProcessor.class.getClassLoader());
		if (!hasClass) {
			log.info("SpringGreetingApplicationRunner is NOT present in CLASSPATH.");
			return;
		}

		if (beanFactory.containsBeanDefinition("springGreetingApplicationRunner")) {
			log.info("We already have a springGreetingApplicationRunner bean registered.");
			return;
		}

		register(beanFactory);
	}

	private void register(ConfigurableListableBeanFactory beanFactory) {
		log.info("====== 开始注册 springGreetingApplicationRunner");
		if (beanFactory instanceof BeanDefinitionRegistry) {
			GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
			beanDefinition.setBeanClass(SpringGreetingApplicationRunner.class);

			((BeanDefinitionRegistry) beanFactory)
					.registerBeanDefinition("springGreetingApplicationRunner",
							beanDefinition);
		} else {
			beanFactory.registerSingleton("springGreetingApplicationRunner",
					new SpringGreetingApplicationRunner());
		}
	}
}
