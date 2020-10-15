import org.junit.Test;

import java.util.List;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-07 17:11
 **/
public class DAOTest {

    @Test
    public void test1(){

        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());
        List<Customer> list = customerDAO.getForList(10);

        StudnetDAO studnetDAO = new StudnetDAO();
        Student student = studnetDAO.getIndex(1);

    }

}
