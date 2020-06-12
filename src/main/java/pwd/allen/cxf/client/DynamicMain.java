package pwd.allen.cxf.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 使用JaxWsDynamicClientFactory调用
 *
 * 如果服务是在JAX-WS的规范来定义，你应该使用jaxwsdynamicclientfactory
 * 如果不想要或不需要JAX-WS语义，使用dynamicclientfactory
 *
 * @author lenovo
 * @create 2020-06-12 17:18
 **/
public class DynamicMain {

    public static void main(String[] args) throws Exception {
        // 按照JAX-WS规范
        DynamicClientFactory dynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        dynamicClientFactory = DynamicClientFactory.newInstance();
        Client client = dynamicClientFactory.createClient("WsTest.xml");
        Object[] res = client.invoke("sayHello", "test echo", "dynamic");
        System.out.println("Echo response: " + res[0]);
    }
}
