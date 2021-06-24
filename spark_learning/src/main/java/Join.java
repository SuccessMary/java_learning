import java.util.Arrays;
import java.util.List;
import org.apache.spark.api.java.function.Function;

import javafx.util.Pair;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

public class Join {
    public static void main(String[] args) {
//        new SparkSession.builder().;
        SparkConf conf = new SparkConf().setAppName("SparkRDD").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);


        List<Integer> a1 = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> rdd1 = sc.parallelize(a1);

        JavaPairRDD<Integer, Integer> pairRDD1 = rdd1.mapToPair(
                (PairFunction<Integer, Integer, Integer>)
                x -> new Tuple2<>(x, x * x));

        JavaPairRDD<Integer, String> pairRDD2 = rdd1.mapToPair(
                (PairFunction<Integer, Integer, String>)
                        x -> new Tuple2<>(x, String.valueOf((char)(64 + x * x))));

        JavaPairRDD<Integer, Tuple2<Integer, String>> joinRDD = pairRDD1.join(pairRDD2);
        JavaRDD<String> res = joinRDD.map(
                (Function<Tuple2<Integer, Tuple2<Integer, String>>, String>)
                x -> {
                    int key = x._1();
                    int value = x._2()._1();
                    String value2 = x._2()._2();
                    return "<" + key + ",<" + value + "," + value2 + ">>";
                });

        System.out.println(pairRDD1.collect());
        System.out.println(pairRDD2.collect());
        System.out.println(res.collect());
        System.out.println(joinRDD.collect());


    }
}
