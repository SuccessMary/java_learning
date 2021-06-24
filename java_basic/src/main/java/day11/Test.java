package day11;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();

        A<String> a1 = new A<>();//在new A对象的时候指定泛型的类型为String
        a1.setKey("xxxx");//对象使用setKey方法中的key形参就是String类型
        String s1 = a1.getKey();//getKey方法的返回值也就是String类型

        A<Integer> a2 = new A<>();
        a2.setKey(1);
        Integer s2 = a2.getKey();

        A a3 = new A();//不指定泛型，相当于指定了Object类型
        a3.setKey(new Object());
        Object s3 = a3.getKey();

        //同样的类，在new对象时指定了不同的数据类型，这些对象不能互相赋值
//        a1 = a2;//这样会报错

    }
}

/**
 * 这个T可以任意取名，比如A,B,V，一般使用大写的T（即type）
 * @param <T>
 */
class A<T>{
    private T key;

    public void setKey(T key){
        this.key = key;
    }

    public T getKey(){
        return this.key;
    }
}
