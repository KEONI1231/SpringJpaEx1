package japbook.jpashop;

import japbook.jpashop.domain.Order;
import japbook.jpashop.domain.OrderItem;
import japbook.jpashop.exdomain.MemberEx;
import japbook.jpashop.exdomain.TeamEx;

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

            Order order = new Order();
            order.addOrderItem(new OrderItem());

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