package pwd.allen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * CXF却需要通过ContextLoaderListener来加载Spring
 *
 * 如果加载到spring mvc容器的话 会找不到service
 *
 * @author 门那粒沙
 * @create 2020-06-13 21:56
 **/
@Configuration
@ImportResource("classpath:/spring-webservice.xml")
public class SpringConfig {
}
