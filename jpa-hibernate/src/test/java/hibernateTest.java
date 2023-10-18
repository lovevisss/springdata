import org.example.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class hibernateTest {
    private SessionFactory sessionFactory;

    @Before
    public void init() throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void test() {
        try {

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer(1L, "张三", "北京");
            customer.setName("李四");
            session.save(customer);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testR(){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            System.out.println(customer);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestU(){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            customer.setName("王五");
            session.update(customer);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestD(){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            session.delete(customer);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestH(){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from Customer where id = :id";
            List<Customer> resultList = session.createQuery(hql, Customer.class)
                    .setParameter("id", 2L)
                    .getResultList();
            System.out.println(resultList);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
