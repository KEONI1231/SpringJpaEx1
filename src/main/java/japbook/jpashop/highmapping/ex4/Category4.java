package japbook.jpashop.highmapping.ex4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category4 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name= "PARENT_ID")
    private Category4 parent;

    @OneToMany(mappedBy = "parent")
    private List<Category4> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
    joinColumns = @JoinColumn(name="CATEGORY_ID"),
    inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
    private List<Item4> items = new ArrayList<>();

}
