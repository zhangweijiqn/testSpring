package test.zwj.Bean;

/**
 * Created by Administrator on 2016/1/2 0002.
 */
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*xml config file must start with：
* <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd
              ">
*
*
* */
public class testMain {
    private static Logger logger = Logger.getLogger(testMain.class);

    private Person person;
    @Test
    public void testPerson(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Person testDI = (Person) ac.getBean("testPerson");
        logger.info("name=" + testDI.getName() + ",age=" + testDI.getAge());
        logger.info("other info: " + testDI.getInfo());



    }
}
