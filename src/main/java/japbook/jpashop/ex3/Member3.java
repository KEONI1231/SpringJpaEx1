package japbook.jpashop.ex3;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member3 {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order3> orders = new ArrayList<>();


}
