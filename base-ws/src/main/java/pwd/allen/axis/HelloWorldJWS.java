package pwd.allen.axis;

/**
 * @author lenovo
 * @create 2020-06-12 15:15
 **/
public class HelloWorldJWS {

    public String test(String a, Integer b) {
        String result = String.format("a=%s,b=%d", a, b);
        System.out.println("接收到：" + result);
        return "Server Response OK, you send：" + result;
    }

}
