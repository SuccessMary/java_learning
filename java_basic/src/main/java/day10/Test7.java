package day10;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("cd");
        list.add("ca");
        list.add("a");
        list.add("1");
        list.add("a");

        //翻转集合元素顺序
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        //打乱，随机排序
        Collections.shuffle(list);
        System.out.println(list);

        //list集合字典升序排列
        Collections.sort(list);
        System.out.println(list);

        //指定位置的元素交换
        Collections.swap(list,0,4);//替换0位置和4位置的元素
        System.out.println(list);

        //最大元素
        System.out.println("集合最大值：" + Collections.max(list));
        //最小元素
        System.out.println("集合最小值：" + Collections.min(list));

        //集合中指定元素的出现次数
        System.out.println("a元素出现次数：" + Collections.frequency(list,"a"));
        System.out.println("D元素出现次数：" + Collections.frequency(list,"D"));

        //替换值
        Collections.replaceAll(list,"a","aa");
        System.out.println("替换后的list：" + list);


        //根据指定的comparator产生排序
        Student s1 = new Student(14,"张三");
        Student s2 = new Student(12,"李四");
        Student s3 = new Student(13,"王五");
        Student s4 = new Student(11,"陈六");

        List<Student> stus = new ArrayList<>();
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        stus.add(s4);
        for (Student stu:stus){
            System.out.println(stu.name + "," + stu.age);
        }
        System.out.println("------------------");
        Collections.sort(stus,new Student());
        for (Student stu:stus){
            System.out.println(stu.name + "," + stu.age);
        }

        //按照指定顺序输出最大最小值
        Student max = Collections.max(stus, new Student());
        System.out.println(max.name + "," + max.age);
        Student min = Collections.min(stus, new Student());
        System.out.println(min.name + "," +  min.age);



    }
}

/**
 * 按照年龄升序排列的比较器
 */
class Student implements Comparator<Student>{
    int age;
    String name;

    public Student(){}

    public Student(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.age > o2.age){
            return 1;
        }else if (o1.age < o2.age){
            return  -1;
        }else{
            return 0;
        }
    }

}
