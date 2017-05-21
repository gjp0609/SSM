import com.baizhi.dao.PersonDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Category;
import com.baizhi.entity.Person;
import com.baizhi.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by gjp06 on 17.5.21.
 */
public class DaoTest {
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    @Test
    void selectUser() {
        UserDao dao = (UserDao) ctx.getBean("userDao");
        List<User> users = dao.selectUser(new User());
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    void selectPerson() {
        PersonDao dao = (PersonDao) ctx.getBean("personDao");
        List<Person> people = dao.selectPerson(new Person());
        for (Person p : people) {
            System.out.println(p);
        }
    }

    @Test
    void insertPerson() {
        PersonDao dao = (PersonDao) ctx.getBean("personDao");
        Person person = new Person();
        Category category = new Category();
        category.setName("1");
        person.setCategory(category);
        person.setName("test");
        person.setBirthday(new Date());
        person.setCity("2q34");
        person.setEmail("234");
        person.setMobile("456");
        person.setTelphone("45645");
        int i = dao.insertPerson(person);
        System.out.println(i + " " + person);
    }

    @Test
    void updatePerson() {
        PersonDao dao = (PersonDao) ctx.getBean("personDao");
        Person person = new Person();
        person.setId(9);
        List<Person> people = dao.selectPerson(person);
        System.out.println(people);
        Person p = people.get(0);
        p.setMobile("123");
        int i = dao.updatePerson(p);
        System.out.println(p);
    }
}
