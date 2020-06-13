package pwd.allen.cxf.client;

import pwd.allen.WsTest;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * 特点：可以自定义命名空间，服务视图名等元素，方便以后维护，是一种标准的开发方式 。
 *
 * 问题：报错：Caused by: javax.wsdl.WSDLException: WSDLException (at /soap:Envelope): faultCode=INVALID_WSDL: Expected element '{http://schemas.xmlsoap.org/wsdl/}definitions'.
 * 原因，wsdl的url不正确
 *
 * @author 门那粒沙
 * @create 2020-06-13 10:28
 **/
public class ServiceMain {

    public static void main(String[] args) throws MalformedURLException, DatatypeConfigurationException {
        //创建WSDL的URL，注意不是服务地址
        URL url = new URL(WsTest.URL + "?wsdl");

        //创建服务名称，这两个要和wsdl文档对应，否则会找不到服务
        //1.namespaceURI - 命名空间地址 (wsdl文档中的targetNamespace)
        //2.localPart - 服务视图名  ，wsdl文档中：<wsdl:service name="WsTestService">
        QName qname = new QName("http://allen.pwd/", "MyWsService");

         // wsdlDocumentLocation - wsdl地址 ，serviceName - 服务名称
        Service service = Service.create(url, qname);
        //获取服务实现类，指定port=MyWsPort  wsdl中：<wsdl:portType name="MobileCodeWSSoap">
        WsTest servicePort = service.getPort(new QName("MyWsPort"), WsTest.class);

        //调用查询方法

        String result = servicePort.sayHello("use Service", "service调用");
        System.out.println(result);

        /**
         * request
         * <soap:Envelope
         *     xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
         *     <soap:Body>
         *         <ns1:CheckTime
         *             xmlns:ns1="http://allen.pwd/">
         *             <clientTime>2020-06-13T11:42:11.564+08:00</clientTime>
         *         </ns1:CheckTime>
         *     </soap:Body>
         * </soap:Envelope>
         *
         * response
         * <soap:Envelope
         *     xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
         *     <soap:Body>
         *         <ns1:CheckTimeResponse
         *             xmlns:ns1="http://allen.pwd/">
         *             <valid>1</valid>
         *         </ns1:CheckTimeResponse>
         *     </soap:Body>
         * </soap:Envelope>
         */
        System.out.println(servicePort.checkTime(new Date()));
    }
}
