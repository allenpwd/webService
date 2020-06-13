package pwd.allen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import java.util.concurrent.TimeUnit;

/**
 * spring MVC配置类
 * @see WebMvcConfigurationSupport
 * @see WebMvcConfigurerAdapter 用于在WebMvcConfigurationSupport基础上定制
 * @see DelegatingWebMvcConfiguration WebMvcConfigurationSupport子类，检测并集成WebMvcConfigurerAdapter
 *
 * 容器配置的方式：
 * 	1）基于web.xml
 * 	2）基于java配置类：继承 {@link AbstractAnnotationConfigDispatcherServletInitializer} 设置根容器和子容器的配置类、servletMappings等
 * 	3）基于xml配置：继承 {@link AbstractDispatcherServletInitializer}
 *
 */
@Configuration
@ComponentScan(basePackages="pwd.allen.controller")
@EnableWebMvc//等价于xml配置中的<mvc:annotation-driven />，原理：引入 DelegatingWebMvcConfiguration 实现
public class MvcConfig extends WebMvcConfigurerAdapter {


	//<editor-fold desc="静态资源配置">
	/**
	 * 由Spring MVC框架自己处理静态资源，更灵活
	 * 优点：允许静态资源放在任何地方，如WEB-INF目录下、类路径下（包括引入的jar类路径下）等
	 *
	 * @see org.springframework.web.servlet.resource.ResourceHttpRequestHandler
	 *
	 * @param registry
	 */
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**")
//				//最好路径以/结尾，否则可能404
//				.addResourceLocations("/static/", "classpath:/META-INF/resources/")
//				//TODO 这个有什么卵用
//				.setCachePeriod(3600 * 24 * 365)
//				//静态资源的Cache-Control响应头设置
//				.setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS));
//	}

}
