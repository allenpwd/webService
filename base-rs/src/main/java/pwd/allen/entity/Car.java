package pwd.allen.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 门那粒沙
 * @create 2020-06-14 9:59
 **/
@Data
@XmlRootElement(name = "car")
public class Car {
    private String name;
    private Double price;
}
