package japbook.jpashop.highmapping.ex4;


import javax.persistence.*;

@Entity
public class Member4 {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name= "USERNAME")
    private String username;

    // 기간
    @Embedded
    private Period workPeriod;
    //주소
    @Embedded
    private Address homeAddress;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
