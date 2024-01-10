package japbook.jpashop.exdomain;

import javax.persistence.*;

@Entity
public class MemberEx {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //@Column(name = "TEAM_ID")
    //private Long teamId;

    @ManyToOne //member 입장에서 다., 즉 여러맴버는 하나의 팀에 가입.
    @JoinColumn(name="TEAM_ID")
    private TeamEx teamEx;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TeamEx getTeamEx() {
        return teamEx;
    }

    public void setTeamEx(TeamEx teamEx) {
        this.teamEx = teamEx;
    }
}
