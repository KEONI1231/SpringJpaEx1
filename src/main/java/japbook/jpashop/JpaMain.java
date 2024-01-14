package japbook.jpashop;

import LAST.domain.Member;
import japbook.jpashop.highmapping.Movie;
import japbook.jpashop.highmapping.cascade.Child;
import japbook.jpashop.highmapping.cascade.Parent;
import japbook.jpashop.highmapping.ex4.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String qlString = "select m From Member4 as m where m.username like '%kim'";
        try {
            //Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member4> query = cb.createQuery(Member4.class);

            Root<Member4> m = query.from(Member4.class);
            CriteriaQuery<Member4> cq = query.select(m).where(cb.equal(m.get("uesrname"), "kim"));
            List<Member4> resultList = em.createQuery(cq)
                    .getResultList();
            String username = "dsafas";
            if(username != null) {
                cq = cq.where(cb.equal(m.get("username"), "kim"));
            }
            List<Member4> result =  em.createQuery(
                    qlString,
                    Member4.class
            ).getResultList();

            for (Member4 member4 : result) {
                System.out.println("member4 = " + member4);
            }

           /* Member4 member = new Member4();
            member.setUsername ("hello");
            member.setHomeAddress(new Address("city", "street", "10000"));
            member.setWorkPeriod(new Period());

            member.getFavoriteFood().add("치킨");
            member.getFavoriteFood().add("족발");
            member.getFavoriteFood().add("피자"); //member만 persist하면 다른 테이블이지만 같이 저장됨.

            member.getAddressHistory().add(new AddressEntity("old1", "street", "10001"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10002" ));
            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============== START ==============");
            Member4 findMember = em.find(Member4.class, member.getId());
            //homeCity -> newCity // 잘못된 예시
            //findMember.getHomeAddress().setCity("newCity"); // 잘못된 예시
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("new City", a.getStreet(), a.getZipcode()));

            //치킨 -> 한식
            findMember.getFavoriteFood().remove("치킨");
            findMember.getFavoriteFood().add("한식");

           
            System.out.println("============== END ==============");*/
            /*findMember.getAddressHistory().remove(new Address("old1", "street", "10001"));
            findMember.getAddressHistory().add(new Address("new City", "street", "10001"));
*/
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