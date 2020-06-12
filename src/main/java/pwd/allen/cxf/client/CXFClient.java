package pwd.allen.cxf.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import pwd.allen.WsTest;

/**
 * 客户端直接调用服务器端提供的服务接口，不需要生成客户端代码，类似RMI的机制。
 * CXF通过运行时代理生成远程服务的代理对象，在客户端完成对webservice的访问。
 * 所以客户端也必须依赖服务器端的接口，限制是很大的，要求服务器端的webservice必须是java实现。似乎失去了webservice跨平台数据调用的意义。
 *
 * @author lenovo
 * @create 2020-06-12 16:17
 **/
public class CXFClient {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(WsTest.class);
        jaxWsProxyFactoryBean.setAddress(WsTest.URL);

        WsTest wsTest = jaxWsProxyFactoryBean.create(WsTest.class);

        System.out.println(wsTest.sayHello("token", "cxf"));
    }
}
