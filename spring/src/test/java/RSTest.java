import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import pwd.allen.entity.User;

import javax.ws.rs.core.MediaType;

/**
 * @author 门那粒沙
 * @create 2020-06-14 11:33
 **/
public class RSTest {

    @Test
    public void rs() {
        User user = WebClient.create("http://localhost:8080/ws/userService/userService/user/1")
//                .type(MediaType.APPLICATION_JSON)  //指定请求的数据格式
                //指定接收的数据格式，不指定则默认xml返回
                .accept(MediaType.APPLICATION_JSON)
                .get(User.class);

        System.out.println(user);
    }
}
