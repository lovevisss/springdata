import org.example.pojo.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPATest {
    EntityManagerFactory entityManagerFactory;
    @Before
    public void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate");


    }

    @Test
    public void testA() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Customer customer = new Customer();
        customer.setName("郑六");
        em.persist(customer);
        transaction.commit();

//        em.close();


    }

    @Test
    public void testB(){
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Customer customer = em.find(Customer.class, 2L);
        System.out.println(customer);
        transaction.commit();
//        em.close();
    }

    @Test
    public void testC() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Customer customer = em.find(Customer.class, 1L);
        customer.setName("王五");
        em.merge(customer);
        transaction.commit();
    }

    @Test
    public void testD(){
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.find(Customer.class, 2L);
        em.find(Customer.class, 2L);
        transaction.commit();
    }
}
