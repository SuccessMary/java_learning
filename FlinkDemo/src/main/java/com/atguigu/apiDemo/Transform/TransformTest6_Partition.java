package com.atguigu.apiDemo.Transform;

import com.atguigu.apiDemo.beans.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class TransformTest6_Partition {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        //从文件读取数据
        DataStream<String> inputStream = env.readTextFile("F:\\java_learning\\FlinkDemo\\src\\main\\resources\\sensor.txt");
        inputStream.print("input");

        //转换成SensorReading类型
        DataStream<SensorReading> dataStream = inputStream.map(new MapFunction<String, SensorReading>() {
            @Override
            public SensorReading map(String s) throws Exception {
                String[] fields = s.split(", ");
                return new SensorReading(fields[0],new Long(fields[1]),new Double(fields[2]));
            }
        });

        //重分区
        // 1. 随机分区
//        inputStream.shuffle().print("shuffle");

//        // 2. keyBy

//        dataStream.keyBy("id").print("keyBy");

        //3. global
        dataStream.global().print("global");



        env.execute();

    }
}
