package japbook.jpashop.ex3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery3 {

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "ORDER_ID")
    private Order3 order;

}
