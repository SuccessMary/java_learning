package day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
//        Set set = new HashSet();
        Set<Object> set = new HashSet<Object>();//与上面的等价，即不写泛型默认为Object类
        //添加元素
        set.add(1);
        set.add("a");
        System.out.println(set);

        //移除元素
        set.remove(1);
        System.out.println(set);

        //判断元素是否存在
        System.out.println(set.contains(1));

        //清空集合
        set.clear();
        System.out.println(set);

        //集合遍历
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        //1.使用迭代器遍历集合
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("======");
        //2.for each迭代集合，推荐使用这种
        for (Object obj:set){  //这个的意思是把set的每一个值取出来，赋值给obj，直到循环set的所有值
            System.out.println(obj);
        }

        //集合大小
        System.out.println("集合元素个数：" + set.size());

        //验证set存的值不可以重复
        set.add("d");
        System.out.println(set);
        //验证set集合可以存null
        set.add(null);
        System.out.println(set);//按照hashCode值进行排序

        //如何想要集合只存储同样类型的对象，怎么做？
        //答：需要使用泛型
        Set<String> set1 = new HashSet<String>();//比如指定String为集合的泛型，
        //那么这个集合就不能存String类型之外的数据了
        set1.add("abc");
//        set1.add(1);//不行
    }
}
