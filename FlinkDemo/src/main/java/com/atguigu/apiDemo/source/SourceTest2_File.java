package com.atguigu.apiDemo.source;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

//从文件中读取数据
public class SourceTest2_File {
    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);//想要按顺序执行，设置并行度为1

        //从文件读取数据
        DataStream<String> dataStream = env.readTextFile("F:\\java_learning\\FlinkDemo\\src\\main\\resources\\sensor.txt");

        //打印输出
        dataStream.print();

        env.execute();
    }
}
