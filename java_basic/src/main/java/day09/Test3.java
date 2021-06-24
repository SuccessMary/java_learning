package day09;

import day08.Test;

public class Test3 {
    int i;
    public int z;
    private int k;

    class A {
        int i; //也可以定义自己的i值，与外部类不冲突
        public void setTest3Fields(){
            Test3.this.i = 1;
            Test3.this.z = 2;
            Test3.this.k = 3;
        }

        public void set(){
            this.i = 10;
        }

    }
    static class B {}

    abstract class C {}

    class D extends C {}


    public void setInfo(){
        new A().setTest3Fields();//外部的类要用自己内部类的方法，得先new内部类的对象
    }

    public void showInfo(){
        System.out.println(this.i);
        System.out.println(this.z);
        System.out.println(this.k);
    }


    public static void main(String[] args) {
        Test3 t = new Test3();
        t.setInfo();
        t.showInfo();
    }
}
