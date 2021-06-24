package day10;

import java.util.Map;
import java.util.TreeMap;

public class Test6_2 {
    public static void main(String[] args) {
        //TreeMap的自然排序指的是key的英文字典排序
        Map<Integer,String> map = new TreeMap<>();
        map.put(4,"a");
        map.put(2,"a");
        map.put(3,"a");
        map.put(1,"a");
        System.out.println(map);

        Map<String,String> map1 = new TreeMap<>();
        map1.put("b","b");
        map1.put("c","d");
        map1.put("d","d");
        map1.put("a","a");
        map1.put("ab","ab");
        map1.put("1","ab");
        map1.put("10","ab");
        System.out.println(map1);

    }
}
