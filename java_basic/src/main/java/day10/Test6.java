package day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test6 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("b",1);//添加数据，用put()
        map.put("c",2);
        map.put("e",2);
        System.out.println(map);

        System.out.println(map.get("b"));//根据key取值

        map.remove("c");//根据key移除键值对
        System.out.println(map);

        System.out.println(map.size());//map集合的长度

        System.out.println(map.containsKey("f"));//判断当前map集合是否包含指定的key
        System.out.println(map.containsValue(5));//判断当前map集合是否包含指定的value

//        map.clear();//清空集合

        map.keySet(); //获取map集合的key集合
        map.values(); //获取map集合的value集合

        //遍历map集合,2种
        //1.通过map.keySet()
        Set<String> keys = map.keySet();
        for (String key : keys){
            System.out.println("key:" + key + ", value:" + map.get(key));
        }
        //2.通过map.entrySet()
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer> en : entries){
            System.out.println("key:" + en.getKey() + ", value:" + en.getValue());
        }

        System.out.println(map.get("A"));


    }
}
