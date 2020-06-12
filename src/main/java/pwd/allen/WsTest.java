package pwd.allen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * @author 门那粒沙
 * @create 2019-06-18 9:52
 **/
@WebService()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WsTest {
    public static final String URL = "http://127.0.0.1:8090/service/WsTest";

    @WebMethod
    public String sayHello(@WebParam(name = "token", header = true) String token, @WebParam(name = "name") String name);

    /**
     * 执行测试的WebService方法(用于时间校验)
     *
     * @param clientTime 客户端时间
     * @return 0表示时间校验失败 1表示校验成功
     */
    @WebMethod
    @WebResult(name = "valid")
    int CheckTime(@WebParam(name = "clientTime") Date clientTime);

}
