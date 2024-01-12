package LAST.ex3;

import LAST.domain.OrderItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
public class Order3 {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member3 member;

    @OneToOne
    @JoinColumn(name="ORDER_ID")
    private Delivery3 delivery;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private Date orderDate;

    private OrderStatus status;
}
