package test.zwj.Aspect;

/**
 * Created by Administrator on 2016/1/3 0003.
 */
public class BServiceImpl implements BService{

    public void barB(String _msg, int _type) {
        System.out.println("BServiceImpl.barB(msg:" + _msg + " type:" + _type + ")");
        if (_type == 1)
            throw new IllegalArgumentException("测试异常");
    }

    public void fooB() {
        System.out.println("BServiceImpl.fooB()");
    }

}