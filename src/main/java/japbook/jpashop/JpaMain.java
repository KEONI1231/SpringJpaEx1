package japbook.jpashop;

import japbook.jpashop.highmapping.Movie;
import japbook.jpashop.highmapping.cascade.Child;
import japbook.jpashop.highmapping.cascade.Parent;
import japbook.jpashop.highmapping.ex4.Address;
import japbook.jpashop.highmapping.ex4.Book;
import japbook.jpashop.highmapping.ex4.Member4;
import japbook.jpashop.highmapping.ex4.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member4 member = new Member4();
            member.setUsername ("hello");
            member.setHomeAddress(new Address("city", "street", "10000"));
            member.setWorkPeriod(new Period());

            em.persist(member);



            //저장
            /* TeamEx team = new TeamEx();
            team.setTeamname("TeamA");
            em.persist(team);

            MemberEx memberEx = new MemberEx();
            memberEx.setUsername("member1");
            memberEx.setTeamEx(team);
            em.persist(memberEx);*/

            //team.getMemberExes().add(memberEx);
            // 연관관계의 주인에게만 값을 넣어야 하지만, 순수 객체 상태를 고려해서 양쪽 값을 모두 입력해주자

            /*em.flush();
            em.clear();*/
            /*MemberEx findMemberEx = em.find(MemberEx.class, memberEx.getId());
            List<MemberEx> memberExes = findMemberEx.getTeamEx().getMemberExes();
            for (MemberEx m : memberExes) {
                System.out.println("m = " + m.getUsername());
            }*/

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}