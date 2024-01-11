package japbook.jpashop.exdomain;

import japbook.jpashop.domain.Locker;
import japbook.jpashop.domain.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member1
{

    @Id @GeneratedValue(strategy = GenerationType.AUTO) //생략하면 오토임
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    //@JoinTable(name = "MEMBER_PRODUCT")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    @OneToOne
    //@JoinColumn(name="LOCKER_ID")
    private Locker locker;

    @OneToMany (mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct> products) {
        this.memberProducts = products;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
