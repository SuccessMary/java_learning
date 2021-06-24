package day09;

public class Test {
    public static void main(String[] args) {
//        new Person();
//        new Person();
//
//        //匿名内部类，这里实际上构建了一个没有类名的Person子类，即匿名的Person子类
//        //这种类没有类名，意味着就不能就显式的new方式创建对象（没有构造器），如果还要在构造器中初始化属性，
//        //就没办法了。这样就要用代码块来做初始化的工作
//        Person p = new Person(){//这就是Person的一个匿名子类
//            //问题？现在想把name改成李四，但不想动Person类的代码
//            //解决：在匿名内部类中，用代码块代替构造方法
//            {
//                super.name = "李四";
//            }
//            @Override //重写方法，就隐式的创建了匿名子类，这个子类没有名，就没法用构造器，所以只能用代码块改值
//            public void test(){
//                System.out.println("=====");
//            }
//        };
//        System.out.println(p.name);
//        p.test();
//
//
//        //测试Animal抽象类
//        Dog d = new Dog();
//        d.move();

//        //测试Employee类
//        CommonEmployee ce = new CommonEmployee();
//        ce.work();
//        ce.setCommonEmployeeInfo(123,"张三",6354.31);
//        ce.getCommonEmployeeInfo();

        //测试Template类
        TestTmp t = new TestTmp();
        t.getTime();

    }
}
