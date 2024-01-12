package LAST.ex3;

import javax.persistence.*;

//@Entity
public class OrderItem3 {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order3 order;



    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item3 item;



    private int orderPrice;

    private int count;

}
