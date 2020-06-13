package pwd.allen.cxf.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
//        dynamicClientFactory = DynamicClientFactory.newInstance();
        Client client = dynamicClientFactory.createClient("WsTest.xml");

        //添加输入拦截器：输入显示日志
        client.getInInterceptors().add(new LoggingInInterceptor());
        //添加输出拦截器：输出显示日志
        client.getOutInterceptors().add(new LoggingOutInterceptor());

        Object[] res = client.invoke("sayHello", "use DynamicClientFactory", "dynamic");
        System.out.println("Echo response: " + res[0]);

        // 这里主要说一下时间日期的xml传递，方法还略显复杂
        GregorianCalendar calender = new GregorianCalendar();
        calender.setTime(new Date(System.currentTimeMillis()));
        XMLGregorianCalendar xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
        res = client.invoke("checkTime", xmldate);
        System.out.println("Echo response: " + res[0]);
    }
}
