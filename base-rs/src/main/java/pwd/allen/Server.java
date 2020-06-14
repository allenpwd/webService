package pwd.allen;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import pwd.allen.service.UserServiceImpl;

/**
 * @author 门那粒沙
 * @create 2020-06-14 10:10
 **/
public class Server {
    public static void main(String[] args) {
        String url = "http://localhost:8000/ws/";

        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();

        //设置服务地址
        factoryBean.setAddress(url);

        //设置服务类
        factoryBean.setServiceBean(new UserServiceImpl());

        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        //发布服务
        factoryBean.create();

        System.out.println("发布成功:" + url);
    }
}
