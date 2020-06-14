package pwd.allen.service;

import pwd.allen.entity.User;

import javax.ws.rs.*;

/**
 * @author 门那粒沙
 * @create 2020-06-14 10:00
 **/
@Path("/userService")
@Produces("*/*")    //服务器支持的返回的数据格式类型
public interface IUserService {

    @GET
    @Path("/user/{id}")
    @Consumes({"application/xml", "application/json"}) //服务器支持的请求的数据格式类型
    @Produces({"application/xml", "application/json"})
    public User getUser(@PathParam("id") Integer id);

}
