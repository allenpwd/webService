package pwd.allen.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pwd.allen.WsTestImpl;

import javax.xml.ws.Endpoint;

/**
 * @author 门那粒沙
 * @create 2020-06-13 23:11
 **/
@Configuration
public class WSConfig {

    @Autowired
    private Bus bus;

    /**
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/hello?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/ws/hello?wsdl
     */
    @Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/ws/*");
    }

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
}
