package day10;

public class Test {
    public static void main(String[] args) {
//        A a = new A();
        A a = null; ///报空指针异常NullPointerException，因为引用的变量A没有指向任何变量，指向的是null
        System.out.println(a.i);
    }
}
class A {
    int i;
}