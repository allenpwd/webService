package pwd.allen.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pwd.allen.WsTest;
import pwd.allen.WsTestImpl;

import javax.xml.ws.Endpoint;

/**
 * @see org.apache.cxf.spring.boot.autoconfigure.CxfAutoConfiguration
 *
 * @author 门那粒沙
 * @create 2020-06-13 23:11
 **/
@Configuration
public class WSConfig {

    @Autowired
    private Bus bus;

    /**
     * 路径配置，改成在application.yml里配置
     */
//    @Bean
//    public ServletRegistrationBean dispatcherServlet(){
//        return new ServletRegistrationBean(new CXFServlet(),"/ws/*");
//    }

    /**
     * 发布服务
     * 指定访问url
     * @return
     */
    @Bean
    public Endpoint userEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new WsTestImpl());
        endpoint.publish("/hello");
        return endpoint;
    }

    /**
     * 客户端
     * @return
     */
    @Bean
    public WsTest wsTest() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(WsTest.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/ws/hello?wsdl");

        return jaxWsProxyFactoryBean.create(WsTest.class);

    }
}
