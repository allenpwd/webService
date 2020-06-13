package pwd.allen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwd.allen.WsTest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 门那粒沙
 * @create 2020-06-13 20:41
 **/
@RequestMapping("test")
@RestController
public class BootController {

    @Autowired
    private WsTest wsTest;

    @GetMapping(value = "hello/{name}" /*, produces = "text/html;charset=utf-8"*/)
    public Object hello(HttpServletRequest request, @PathVariable("name") String name) {
        System.out.println(name);
        return "hello!" + name;
    }

    @GetMapping("ws/{name}")
    public Object ws(HttpServletRequest request, @PathVariable("name") String name) {
        return wsTest.sayHello("use cxf in spring", name);
    }
}
