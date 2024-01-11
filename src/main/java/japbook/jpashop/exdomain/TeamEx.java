package japbook.jpashop.exdomain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamEx {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String teamname;

    @OneToMany(mappedBy = "teamEx") // mappedby : 일대다 매핑에서 뭐랑 걸려있냐.
    private List<MemberEx> memberExes = new ArrayList<>(); //양뱡향, 읽기 전용

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public List<MemberEx> getMemberExes() {
        return memberExes;
    }

    public void setMemberExes(List<MemberEx> memberExes) {
        this.memberExes = memberExes;
    }
}
