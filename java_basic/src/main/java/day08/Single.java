package day08;

/**
 * 实现一个饿汉式的单例
 * @author jf
 */

public class Single {

    //私有的构造，构造方法私有化，调用这个类的人就不能直接之用new来创建对象
    private Single(){

    }

    //私有的Single类型的类变量
    private static final Single single = new Single();

    //公有的getInstance方法
    public static Single getInstance(){
        return single;
    }
}
