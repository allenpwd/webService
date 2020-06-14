package pwd.allen.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 基于restful风格的webservice
 *
 * @author 门那粒沙
 * @create 2020-06-14 9:16
 **/
@XmlRootElement(name = "user") //指定对象序列化为xml或者json数据
@Data
public class User {
    private Integer id;
    private String name;
    private Date birthAt;
    private List<Car> cars = new ArrayList<>();
}
