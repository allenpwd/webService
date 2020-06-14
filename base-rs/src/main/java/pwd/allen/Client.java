package pwd.allen;

import org.apache.cxf.jaxrs.client.WebClient;
import pwd.allen.entity.User;

import javax.ws.rs.core.MediaType;

/**
 * @author 门那粒沙
 * @create 2020-06-14 10:16
 **/
public class Client {
    public static void main(String[] args) {
        User user = WebClient.create("http://localhost:8000/ws/userService/user/1")
//                .type(MediaType.APPLICATION_JSON)  //指定请求的数据格式
                .accept(MediaType.APPLICATION_JSON)
                //指定接收的数据格式，不指定则默认xml返回
                .get(User.class);

        System.out.println(user);
    }
}
