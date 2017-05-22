import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import javax.sql.DataSource

/**
 * Created by gjp06 on 17.5.22.
 */

public class EnvTest12 {
    internal var ctx: ApplicationContext = ClassPathXmlApplicationContext("spring.xml") as ApplicationContext
    @Test
    fun t1() {
        val ds = ctx.getBean("ds") as DataSource
        println(ds)
    }
}