package pwd.allen.jws.server;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebService(endpointInterface = "pwd.allen.jws.server.WsTest")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WsTestImpl implements WsTest {

    @Override
    public String sayHello(String token, String name) {
        return "Hello!" + name;
    }

    @Override
    public int CheckTime(Date clientTime) {
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