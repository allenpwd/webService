package pwd.allen.jdk.server;

import pwd.allen.WsTest;
import pwd.allen.WsTestImpl;

import javax.xml.ws.Endpoint;

/**
 * 使用jax-ws方式（Java EE原生代码方式）
 *
 * @author 门那粒沙
 * @create 2019-06-18 9:56
 **/
public class JDKMain {

    public static void main(String[] args) {
        Endpoint.publish(WsTest.URL, new WsTestImpl());
        System.out.println(WsTest.URL + "?wsdl");
    }
}
