import org.example.pojo.Customer;
import org.example.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

@ContextConfiguration(locations = {"classpath:spring.xml"})
//@ContextConfiguration(classes = org.example.config.SpringDataJPAConfig.class)
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
public class SpringdataTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test(){
        Optional<Customer> byId = customerRepository.findById(2L);

        System.out.println(byId.get());
    }

    @Test
    public void test2(){
        Customer customer = new Customer();
        customer.setId(4L);
        customer.setName("James May");
        customerRepository.save(customer);
    }

    @Test
    public void test3(){
        Customer customer = new Customer();
        customer.setId(8L);
        customer.setAddress("London");
        customerRepository.save(customer);
    }

}
