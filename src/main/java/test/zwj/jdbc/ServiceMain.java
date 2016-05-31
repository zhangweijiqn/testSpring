package test.zwj.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.zwj.Bean.Person;

import java.util.List;

/**
 * Created by Administrator on 2016/1/5 0005.
 */
public class ServiceMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        PersonDAO personDAO = (PersonDAOImpl) ac.getBean("PersonDAO");
        List<Person>persons = personDAO.getPersonByName("zhang");
        for(Person person:persons){
            System.out.println(person);
        }

    }

}
