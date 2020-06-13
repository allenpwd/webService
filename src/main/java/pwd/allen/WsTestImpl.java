package pwd.allen;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @WebService-定义服务，在类上边
 *     targetNamespace：指定命名空间
 *     name：portType的名称
 *     portName：port的名称
 *     serviceName：服务名称
 *     endpointInterface：SEI接口地址，如果一个服务类实现了多个接口，只需要发布一个接口的方法，可通过此注解指定要发布服务的接口。
 *
 * @WebMethod-定义方法，在公开方法上边
 *     operationName：方法名
 *     exclude：设置为true表示此方法不是webservice方法，反之则表示webservice方法，默认是false
 *
 * @WebResult-定义返回值，在方法返回值前边
 *     name：返回结果值的名称
 *
 * @WebParam-定义参数，在方法参数前边
 *     name：指定参数的名称
 *
 * @author 门那粒沙
 * @create 2019-06-18 9:52
 **/
@WebService(endpointInterface = "pwd.allen.WsTest", serviceName = "MyWsService", portName = "MyWsPort")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WsTestImpl implements WsTest {

    @Override
    public String sayHello(String token, String name) {
        return String.format("Hello!%s, your token is 【%s】", name, token);
    }

    @Override
    public int checkTime(Date clientTime) {
        // 精确到秒
        String dateServer = new java.sql.Date(System.currentTimeMillis())
                .toString()
                + " "
                + new java.sql.Time(System.currentTimeMillis());
        String dateClient = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(clientTime);
        return dateServer.equals(dateClient) ? 1 : 0;
    }

}