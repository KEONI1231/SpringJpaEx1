package japbook.jpashop.highmapping.ex4;

import LAST.ex3.Item3;
import LAST.ex3.Order3;

import javax.persistence.*;

@Entity
public class OrderItem4 {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order4 order;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ITEM_ID")
    private Item3 item;



    private int orderPrice;

    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order4 getOrder() {
        return order;
    }

    public void setOrder(Order4 order) {
        this.order = order;
    }

    public Item3 getItem() {
        return item;
    }

    public void setItem(Item3 item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
