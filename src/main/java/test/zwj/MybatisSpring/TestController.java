package test.zwj.MybatisSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by zhangweijian on 2015/11/11.
 */
@Controller
public class TestController {
    @Autowired
    private  TestService testService;

    public void test(){
        List<User> users = testService.getUserMapper("0");
        for(User usr:users){
            System.out.println(usr);
        }
    }

    public static void main(String args[]){
        //        通过ApplicationContext来获取Spring配置文件
        ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/resources/mybatisConfig.xml");
//        通过Bean的id来获取bean
        TestController testController= new TestController();
        testController.test();
    }

}
