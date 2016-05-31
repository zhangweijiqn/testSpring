package test.zwj.Aspect;

import test.zwj.Aspect.AService;

/**
 * Created by Administrator on 2016/1/3 0003.
 */
// 使用jdk动态代理
public class AServiceImpl implements AService {

    public void barA() {
        System.out.println("AServiceImpl.barA()");
    }

    public void fooA(String _msg) {
        System.out.println("AServiceImpl.fooA(msg:" + _msg + ")");
    }
}
