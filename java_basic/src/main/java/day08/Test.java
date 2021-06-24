package day08;

import java.util.Base64;

public class Test {
    public static void main(String[] args) {
//        Integer i = new Integer("123000");
//        Integer i = new Integer("abc");//这样的编译是没错的，但是运行会出错
//        System.out.println(i);
//        Integer i = new Integer(112);
//        int i0 = i.intValue();
//        System.out.println(i0);
//
//        Integer i1 = 112;//自动装箱
//        int i2 = i1;//自动拆箱
//
////        Boolean b = new Boolean("false").booleanValue();
//        Boolean b = new Boolean("false");//自动拆箱
//        Boolean b1 = true;//自动装箱
//        System.out.println(b);

        int i = Integer.parseInt("123");
        float f = Float.parseFloat("0.40");
        boolean b = Boolean.parseBoolean("false");

        String istr = String.valueOf(i);
        String fstr = String.valueOf(f);
        String bstr = String.valueOf(b);


        Chinese.country = "China";
        Chinese c = new Chinese();
        Chinese.age = 16;
        Chinese.name = "Mary";
        //要是再写一个对象，要重复上述
        //能不能只写一次国籍，让所有的对象都是用一个相同的国籍：有，用static

        Chinese c1 = new Chinese();
        Chinese c2 = new Chinese();
        System.out.println(Chinese.country);
        System.out.println(Chinese.country);
        System.out.println(Chinese.country);

        Chinese.test();

        //判断字符串是不是一个空字符串
        String s = "ll";
        System.out.println(Utils.isEmpty(s));

        Chinese c3 = new Chinese();
        Chinese c4 = new Chinese();
        Chinese c5 = new Chinese();
        Chinese.showCount();

    }

//    Single s = new Single(); Single类是私有的，无法通过new方法调用
//    Single s = Single.getInstance();
//    Single s1 = Single.getInstance();
//    Single s2 = Single.getInstance();
//    Single s3 = Single.getInstance();
//    Single s4 = Single.getInstance();

    Single1 s = Single1.getInstance();
    Single1 s1 = Single1.getInstance();
    Single1 s2 = Single1.getInstance();
    Single1 s3 = Single1.getInstance();
    Single1 s4 = Single1.getInstance();



}
