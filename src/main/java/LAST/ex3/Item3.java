package LAST.ex3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Item3 {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    @ManyToMany(mappedBy = "items")
    private List<Category3> categories = new ArrayList<>();

}
