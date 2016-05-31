package test.zwj.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import test.zwj.Bean.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/5 0005.
 * 将来可以转换为注解的形式
 */
public class PersonDAOImpl implements PersonDAO {
    private JdbcTemplate jdbcTemplate = null;

    //here needs to be injected autowired, we inject through xml configure
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getPersonByName(String Name) {
        String sql="select * from person where Name like ?";
//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("name",Name);
        return jdbcTemplate.query(sql, new Object[] {Name+"%"},new RowMapper<Person>() {
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setName(rs.getString("name"));
                person.setAge(Integer.parseInt((rs.getString("age"))));
                return person;
            }
        });
    }
}
