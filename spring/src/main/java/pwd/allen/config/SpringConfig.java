package pwd.allen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 问题：如果加载到spring mvc容器的话 会找不到service
 * 原因：CxfServlet是从根容器加载服务的，而springmvc容器是子容器，所以要把webservice服务放到它的父容器里去；或者把springmvc容器设置成根容器
 *
 * @author 门那粒沙
 * @create 2020-06-13 21:56
 **/
@Configuration
@ImportResource("classpath:/spring-webservice.xml")
public class SpringConfig {
}
