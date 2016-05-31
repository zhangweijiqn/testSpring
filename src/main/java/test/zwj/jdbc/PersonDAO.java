package test.zwj.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import test.zwj.Bean.Person;

import java.util.List;

/**
 * Created by Administrator on 2016/1/5 0005.
 */
public interface PersonDAO {
    public List<Person> getPersonByName(String Name);
}
