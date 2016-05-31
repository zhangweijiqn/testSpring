package test.zwj.log4j;

/**
 * Created by Administrator on 2016/1/2 0002.
 */
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testMain {
    private static Logger logger = Logger.getLogger(testMain.class);
    @Test
    public void TestLog4j() {
        // System.out.println("This is println message.");

        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }

}
