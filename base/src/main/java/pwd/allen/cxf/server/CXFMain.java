package pwd.allen.cxf.server;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import pwd.allen.WsTest;
import pwd.allen.WsTestImpl;

import javax.xml.namespace.QName;

/**
 * JaxWsServerFactoryBean是ServerFactoryBean的子类，也是功能扩展类。该类可用来发布WebService，此类必须要在被发布为服务的类上添加@WebService注解，如果不加注解，虽然不出错，但也不会对外暴露任何方法。
 * 使用此类生成的wsdl文件更加规范，更重要的是可以通过添加拦截器拦截请求
 *
 * 需要引入cxf、jetty相关包
 *
 * @author lenovo
 * @create 2020-06-12 16:20
 **/
public class CXFMain {

    public static void main(String[] args) {

        JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
        //设置地址
        jaxWsServerFactoryBean.setAddress(WsTest.URL);

        // 可以修改服务名称
        //  命名空间地址：默认服务类包或服务Bean路径的倒序
        //  Service名：默认服务类名或服务Bean名 + Service
//        jaxWsServerFactoryBean.setEndpointName(new QName("http://allen.pwd/", "MyWsTestService"));

        //对外提供的付服务类或者接口
        jaxWsServerFactoryBean.setServiceClass(WsTest.class);

        // 指定服务实现bean，必需
        jaxWsServerFactoryBean.setServiceBean(new WsTestImpl());

        //添加输入拦截器：输入显示日志
        jaxWsServerFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        //添加输出拦截器：输出显示日志
        jaxWsServerFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        //创建并发布
        jaxWsServerFactoryBean.create();
        System.out.println(WsTest.URL + "?wsdl");
    }
}
