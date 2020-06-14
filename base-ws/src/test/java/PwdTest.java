import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author 门那粒沙
 * @create 2020-06-12 20:08
 **/
public class PwdTest {

    /**
     * 测试使用DynamicClientFactory 调用天气接口
     * @throws Exception
     */
    @Test
    public void dynamic() throws Exception {
        // 按照JAX-WS规范
        DynamicClientFactory dynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        dynamicClientFactory = DynamicClientFactory.newInstance();
        Client client = dynamicClientFactory.createClient("WeatherWebService.xml");

        Object[] res = client.invoke("getSupportCity", "广东");
        // res[0]类型是ArrayOfString，是服务端自定义的；这种动态代理的方式没法拿到自定义类型的值
        System.out.println("class type :" + res[0].getClass());
        Method getString = res[0].getClass().getDeclaredMethod("getString");
        System.out.println("结果：" + getString.invoke(res[0]));
    }
}
