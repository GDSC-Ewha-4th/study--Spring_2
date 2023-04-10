package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
          // Member findMember = em.find(Member.class, 1L);
          Member member = new Member();
          member.setUsername("C");

          em.persist(member);
        }catch(Exception e){
             tx.rollback();
        }finally {
            em.close();//꼭 닫아줘야함
        }

        emf.close();
    }
}
