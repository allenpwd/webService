package pwd.allen.jws.server;

import pwd.allen.jws.server.WsTestImpl;

import javax.xml.ws.Endpoint;

/**
 * @author 门那粒沙
 * @create 2019-06-18 9:56
 **/
public class ServerMain {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8090/service/WsTest", new WsTestImpl());
    }
}
