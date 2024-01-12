package japbook.jpashop.highmapping.ex4;

import LAST.domain.OrderItem;
import LAST.ex3.Delivery3;
import LAST.ex3.Member3;
import LAST.ex3.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Order4 {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member4 member;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="DELIVERY_ID")
    private Delivery4 delivery ;

    /*@OneToMany(mappedBy = "order")
    private List<OrderItem4> orderItems = new ArrayList<>();
*/

    @OneToMany(mappedBy = "order")
    private List<OrderItem4> orderItems = new ArrayList<>();


    private Date orderDate;

    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member4 getMember4() {
        return member;
    }

    public void setMember4(Member4 member4) {
        this.member = member4;
    }

    public Delivery4 getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery4 delivery) {
        this.delivery = delivery;
    }

    public Member4 getMember() {
        return member;
    }

    public void setMember(Member4 member) {
        this.member = member;
    }

    public List<OrderItem4> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem4> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
