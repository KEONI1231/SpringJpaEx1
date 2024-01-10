package japbook.jpashop;

import japbook.jpashop.exdomain.MemberEx;
import japbook.jpashop.exdomain.TeamEx;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //저장
            TeamEx team = new TeamEx();
            team.setTeamname("TeamA");
            em.persist(team);

            MemberEx memberEx = new MemberEx();
            memberEx.setUsername("member1");
            memberEx.setTeamEx(team);
            em.persist(memberEx);

            em.flush();
            em.clear();
            MemberEx findMemberEx = em.find(MemberEx.class, memberEx.getId());

            List<MemberEx> memberExes = findMemberEx.getTeamEx().getMemberExes();

            for (MemberEx m : memberExes) {
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}