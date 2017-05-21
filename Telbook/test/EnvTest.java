import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * Created by gjp06 on 17.5.21.
 */
public class EnvTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    @Test
    void ds() {
        DataSource ds = (DataSource) ctx.getBean("ds");
        System.out.println(ds);
    }
    @Test
    void ssf() {
         SqlSessionFactory ssf = (SqlSessionFactory) ctx.getBean("ssf");
        System.out.println(ssf);
    }


}
