package pwd.allen.jdk.client;


import pwd.allen.jdk.client.wsimport.MyWsService;
import pwd.allen.jdk.client.wsimport.WsTest;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 调用 wsimport 生成客户端代码
 *
 * @author 门那粒沙
 * @create 2019-08-18 16:53
 **/
public class ClientMain {

    public static void main(String[] args) throws DatatypeConfigurationException {
        WsTest service = new MyWsService().getMyWsPort();

        String sayHello = service.sayHello("call created by wsimport", "pwd");
        System.out.println("sayHello--" + sayHello);

        // 这里主要说一下时间日期的xml传递，方法还略显复杂
        GregorianCalendar calender = new GregorianCalendar();
        calender.setTime(new Date(System.currentTimeMillis()));
        XMLGregorianCalendar xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
        System.out.println(service.checkTime(xmldate));
    }
}
