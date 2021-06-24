package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("b");
        list.add("d");
        list.add("c");
        list.add("a");
        System.out.println(list);//按元素添加顺序来创建索引下标
        System.out.println(list.get(2));
        list.add("d");//可重复
        System.out.println(list);

        list.add(1,"f");//在指定索引下标位置插入数据
        System.out.println(list);

        //插入一个集合
        List<String> l = new ArrayList<String>();
        l.add("123");
        l.add("456");
        list.addAll(2,l);//在指定索引下标位置插入一个集合
        System.out.println(list);

        System.out.println(list.indexOf("d"));//获取指定元素在集合中第一次出现的索引下标
        System.out.println(list.lastIndexOf("d"));//获取指定元素在集合中最后一次出现的索引下标

        list.remove("123");//移除元素
        System.out.println(list);

        list.set(1,"ff");//指定下标修改元素
        System.out.println(list);

        List<String> subList = list.subList(2,4);//根据索引下标的起始位置来截取一段元素，形成一个新的集合
        //截取时左闭右开
        System.out.println(subList);

        System.out.println(list.contains("e"));
        System.out.println("集合的长度" + list.size());

        int[] test = {5,8,7,2,64};
        System.out.println(test);
//        ArrayList test_array = new ArrayList();
        List<Integer> test_array = Arrays.asList(5,8,7,2,64);
//        System.out.println(test_array);
        System.out.println(test_array.indexOf(64));

    }
}
