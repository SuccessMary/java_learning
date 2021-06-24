package day08;
/**
 * 懒汉式的单例模式
 * @author jf
 */

public class Single1 {

    //先私有化构造方法，让外边不能直接new对象
    private Single1(){}

    //再做一个私有化的Single1的类变量
    private static Single1 s1 = null;

    public static Single1 getInstance(){
        if (s1 == null){ //判断s1是否为null，为null，说明是第一个人在调用，就要进行实例化
            s1 = new Single1();
        }
        return s1;
    }

}
