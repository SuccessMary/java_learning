package com.atguigu.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class StreamWordCount {
    public static void main(String[] args) throws Exception{
        //创建流处理执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(8);//设置并发，并行度默认为4

        //读取文件数据
        String inputPath = "F:\\java_learning\\FlinkDemo\\src\\main\\resources\\hello.txt";
//        DataStream<String> inputStream = env.readTextFile(inputPath);

        //用parameter tool工具从程序启动参数中提取配置项(代码提交到生产环境时，不该把端口等配置写死，
        // 需要在对程序传参时提取配置参数)
        //如果想在代码开发环境测试代码，则点击run->edit configuration->进行传参
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        String host = parameterTool.get("host");
        int port = parameterTool.getInt("port");
        System.out.println(host+port);

        //真正的流数据，比如从kafka获取数据
        //本地模拟的话，可以用nc(netcat)模拟
        //从socket文本流读取数据
        DataStream<String> inputStream = env.socketTextStream(host,port);


        //基于数据流进行转换计算
        DataStream<Tuple2<String, Integer>> resultStream = inputStream.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] words = s.split(" ");
                for (String word : words) {
                    collector.collect(new Tuple2<>(word, 1));
                }
            }
        }).keyBy(0).sum(1); //元组取某位置元素写法

        resultStream.print();

        //执行任务
        env.execute();
    }
}
