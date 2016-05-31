package test.zwj.MybatisSpring;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangweijian on 2015/11/11.
 */
@Repository
public interface UserMapper {
    @Select("SELECT * FROM access_user WHERE id = #{userId}")
    @Results({
            @Result(column = "account", property = "name")
    })
    List<User> getUser(@Param("userId") String userId);
}
 