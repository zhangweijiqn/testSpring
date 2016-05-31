package test.zwj.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2016/1/3 0003.
 *
 * @Aspect needs aop namespace
 * configure xml with <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 */
@Aspect
public class AnnoAspectTest {
   @Pointcut("execution(* test.zwj.Bean.*.*(..))")
   public void getName(){

   }
   @Before("getName()")
    public void dobefore(){
        System.out.println("before called!");
    }
    @After("getName()")
    public void doafter(){
        System.out.println("after called!");
    }
}
