package japbook.jpashop.ex3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category3 {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private Category3 parent;

    @OneToMany(mappedBy = "parent")
    private List<Category3> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="CATEGORY_ITEM", joinColumns = @JoinColumn(name="CATEGORY_ID"),
    inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
    private List<Item3> items = new ArrayList<>();
}
