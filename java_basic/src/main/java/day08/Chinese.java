package day08;

public class Chinese {
    public Chinese(){
        count += 1;
    }

    static String country;
    static String name;
    static int age;
    public static int count;

    public static void test(){
        System.out.println("这是一个静态方法");
    }

    public static void showCount(){
        System.out.println("总共new了" + Chinese.count + "个对象");
    }
}
