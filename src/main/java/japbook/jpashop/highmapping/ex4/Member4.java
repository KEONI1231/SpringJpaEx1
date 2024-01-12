package japbook.jpashop.highmapping.ex4;


import LAST.ex3.Order3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member4 {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order4> orders = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Order4> getOrders() {
        return orders;
    }

    public void setOrders(List<Order4> orders) {
        this.orders = orders;
    }
}
