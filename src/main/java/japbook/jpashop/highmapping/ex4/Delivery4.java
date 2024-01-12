package japbook.jpashop.highmapping.ex4;

import javax.persistence.*;

@Entity
public class Delivery4 {
    @Id @GeneratedValue
    @Column(name= "DELIVERY_ID")
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    private Delivery4Status status;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order4 order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Delivery4Status getStatus() {
        return status;
    }

    public void setStatus(Delivery4Status status) {
        this.status = status;
    }

    public Order4 getOrder() {
        return order;
    }

    public void setOrder(Order4 order) {
        this.order = order;
    }
}
