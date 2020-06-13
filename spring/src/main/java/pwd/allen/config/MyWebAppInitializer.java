package pwd.allen.config;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * WebApplicationInitializer：可以看做是Web.xml的替代，在其中可以添加servlet，listener等，在加载Web项目的时候会加载这个接口实现类
 * 	原理：SpringServletContainerInitializer通过SPI机制在web容器启动时被实例化并调用，
 * 	调用的结果就是得到WebApplicationInitializer子类，逐个实例化并调用他们的onStartup方法
 * 	@see org.springframework.web.SpringServletContainerInitializer
 * 	@see javax.servlet.ServletContainerInitializer
 *
 * @author 门那粒沙
 * @create 2020-02-11 10:47
 **/
public class MyWebAppInitializer implements WebApplicationInitializer {
    /**
     * 将在web容器加载时被调用，可以替代web.xml的功能
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) {

        // 配置cxfServlet
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("cxfServlet", CXFServlet.class);
        dynamic.addMapping("/ws/*");

        // 处理乱码
        FilterRegistration.Dynamic dynamicFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        dynamicFilter.setInitParameter("encoding", "utf-8");
        dynamicFilter.setInitParameter("forceResponseEncoding", "true");
        dynamicFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
