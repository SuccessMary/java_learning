package com.atguigu.apiDemo.source;

import com.atguigu.apiDemo.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

//从集合中读取数据
public class SourceTest1_Collection {
    public static void main(String[] args) throws Exception {
        ///创建执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);//想要按照顺序读取。设置并发分区（线程）为1

        ///从集合中读取数据
        DataStream<SensorReading> dataStreamSource = env.fromCollection(Arrays.asList(
                new SensorReading("sensor_1", 1547718199L, 35.80018327300259),
                new SensorReading("sensor_6", 1547718201L, 15.402984393403084),
                new SensorReading("sensor_7", 1547718202L, 6.720945201171228),
                new SensorReading("sensor_10", 1547718205L, 38.101067604893444)
        ));

        DataStreamSource<Integer> integerDataStreamSource = env.fromElements(1, 2, 4, 67, 15);

        //打印输出
        dataStreamSource.print("data");//括号里进行区分
        integerDataStreamSource.print("int");


        env.execute("SourceTest1-Collection");


    }
}
