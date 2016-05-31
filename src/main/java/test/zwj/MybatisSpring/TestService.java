package test.zwj.MybatisSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangweijian on 2015/11/11.
 */
@Service
public class TestService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUserMapper(String id) {
        return userMapper.getUser(id);
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
