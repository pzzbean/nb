package com.ibase.core.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring bean管理
 * @author admin
 *
 */
public class BeanUtil implements ApplicationContextAware {
	
		public BeanUtil() {
		}

		private static ApplicationContext context = null;

		@Override
		public void setApplicationContext(ApplicationContext appContext){
			context = appContext;
		}

		@SuppressWarnings("unchecked")
		public static <T> T getBean(String beanName) {
			return (T) context.getBean(beanName);
		}
}
