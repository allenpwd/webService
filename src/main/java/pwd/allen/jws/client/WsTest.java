
package pwd.allen.jws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WsTest", targetNamespace = "http://server.jws.allen.pwd/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsTest {


    /**
     * 
     * @param name
     * @param token
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server.jws.allen.pwd/WsTest/sayHelloRequest", output = "http://server.jws.allen.pwd/WsTest/sayHelloResponse")
    public String sayHello(
            @WebParam(name = "token", targetNamespace = "http://server.jws.allen.pwd/", header = true, partName = "token")
                    String token,
            @WebParam(name = "name", partName = "name")
                    String name);

    /**
     * 
     * @param clientTime
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CheckTime")
    @WebResult(name = "valid", partName = "valid")
    @Action(input = "http://server.jws.allen.pwd/WsTest/CheckTimeRequest", output = "http://server.jws.allen.pwd/WsTest/CheckTimeResponse")
    public int checkTime(
            @WebParam(name = "clientTime", partName = "clientTime")
                    XMLGregorianCalendar clientTime);

}
