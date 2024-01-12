package japbook.jpashop.highmapping.cascade;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

    @Id @GeneratedValue
    @Column(name = "parent_id")
    private Long id;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    //고아객체 제거.
    // 마찬가지로 참조하는 곳이 하나일때만 사용
    private List<Child> childList = new ArrayList<>(); //child가 다른 Entity랑 연관관계가 없을때만 사용해라.
    //단일엔티티에 완전히 종속적일때.
    //라이프사이클이 똑같을때.//소유자가하나일때.

    public void addChild(Child child) {
        childList.add(child);
        child.setParent(this);
    }
    private String name;

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

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
}
