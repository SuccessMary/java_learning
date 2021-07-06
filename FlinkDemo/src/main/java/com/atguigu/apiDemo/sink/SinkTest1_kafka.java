package com.atguigu.apiDemo.sink;

import com.atguigu.apiDemo.beans.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

public class SinkTest1_kafka {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = new StreamExecutionEnvironment();
        env.setParallelism(1);

//        env.socketTextStream();

        //从文件读取数据
        DataStream<String> inputStream = env.readTextFile("F:\\java_learning\\FlinkDemo\\src\\main\\resources\\sensor.txt");

        //转换成SensorReading类型
        DataStream<String> dataStream = inputStream.map(new MapFunction<String, String>() {
            @Override
            public String map(String s) throws Exception {
                String[] fields = s.split(", ");
                return new SensorReading(fields[0],new Long(fields[1]),new Double(fields[2])).toString();
            }
        });

//        dataStream.writeToSocket();
        dataStream.addSink(new FlinkKafkaProducer011<String>("localhost:9092","sinkTest",new SimpleStringSchema()));

        env.execute();

    }
}
