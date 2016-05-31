package test.zwj.Aspect;

/**
 * Created by Administrator on 2016/1/2 0002.
 */
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.zwj.Bean.Info;
import test.zwj.Bean.Person;

/*
* maven dependencies needed:
*<!-- aop -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>3.0.5.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjrt</artifactId>
        <version>1.8.6</version>
    </dependency>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.8.6</version>
    </dependency>
*
* */
public class testMain {
    private static Logger logger = Logger.getLogger(testMain.class);
    @Test
    public void testPerson(){

        ApplicationContext ac1 = new ClassPathXmlApplicationContext("spring-config.xml");
        Person testDI = (Person) ac1.getBean("testPerson");
        System.out.println("name="+testDI.getName()+",age="+testDI.getAge());
        System.out.println("other info: " + testDI.getInfo());
        //annotation aspect injected successfully

        Person person = new Person();
        Info info = new Info();
        info.setBirthday("aaa");
        info.setTelphone("aaa");
        person.setInfo(info);
        System.out.println(person.getInfo());
        //aspect injected failed, person is not a defined bean get by applicationContext

        ApplicationContext ac = new ClassPathXmlApplicationContext("Aspect-config.xml");
        AService aService = (AService) ac.getBean("aService");
        aService.barA();
        BService bService = (BService) ac.getBean("bService");
        try {
            bService.barB("aaa", 1);
        }catch (Exception e){
            //aspect injected successfully
        }
    }
}
