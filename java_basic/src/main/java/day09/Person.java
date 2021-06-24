package day09;

public class Person {
    String name;
    static int age;
    static TestPerson tp = new TestPerson();

    public Person(){
        this.name = "张三";
        System.out.println("执行的是构造方法");
    }

    //非静态的代码块
    {
        System.out.println("执行的是非静态代码块1");
    }
    {
        System.out.println("执行的是非静态代码块2");
    }
    {
        System.out.println("执行的是非静态代码块3");
    }

    //静态代码块：只能使用静态修饰的属性和方法
    static {
        age = 1;
        showAge();
        System.out.println("===执行的是静态代码块===");
        tp.name = "";
        tp.age = 1;
    }

    public static void showAge(){
        System.out.println(age);
    }

    public void test(){
        System.out.println("Person的test方法");
    }
}
