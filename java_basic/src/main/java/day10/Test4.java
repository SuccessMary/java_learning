package day10;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test4 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        //TreeSet自然排序
        set.add(5);
        set.add(4);
        set.add(2);
        set.add(3);
        System.out.println(set);

        set.remove(5);
        System.out.println(set.contains(3));
//        set.clear();
        System.out.println(set);

        //使用迭代器遍历集合
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=====");
        //for each遍历集合
        for(Object i:set){
            System.out.println(i);
        }

        //定制排序
        Person p1 = new Person("张三",23);
        Person p2 = new Person("李四",20);
        Person p3 = new Person("王五",16);
        Person p4 = new Person("Lucy",29);

        Set<Person> set1 = new TreeSet<Person>(new Person()); //new Person相当于传入一个比较器，TreeSet会按照比较器中的顺序进行排序
        set1.add(p1);
        set1.add(p2);
        set1.add(p3);
        set1.add(p4);

        for (Person p:set1){
            System.out.println(p.name + "    " + p.age);
        }
    }
}

class Person implements Comparator<Person> { //把Person对象存到TreeSet中，并按照年龄排序
    int age;
    String name;

    public Person(){} //无参构造，不写的话，java会默认只有 有参构造器，导致无参不能使用，即无法new对象

    public Person(String name,int age){  //有参构造
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Person o1, Person o2) { //年龄正序
        if (o1.age > o2.age){
            return 1;
        }else if (o1.age < o2.age){
            return -1;
        }else{
            return 0;
        }
    }

//    @Override
//    public int compare(Person o1, Person o2) {  //年龄倒序排列
//        if (o1.age < o2.age){
//            return 1;
//        }else if (o1.age > o2.age){
//            return -1;
//        }else{
//            return 0;
//        }

}
