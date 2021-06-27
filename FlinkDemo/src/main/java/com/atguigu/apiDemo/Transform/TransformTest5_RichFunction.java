package com.atguigu.apiDemo.Transform;

import com.atguigu.apiDemo.beans.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class TransformTest5_RichFunction {
    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        //从文件读取数据
        DataStream<String> inputStream = env.readTextFile("F:\\java_learning\\FlinkDemo\\src\\main\\resources\\sensor.txt");

        //转换成SensorReading类型
        DataStream<SensorReading> dataStream = inputStream.map(new MapFunction<String, SensorReading>() {
            @Override
            public SensorReading map(String s) throws Exception {
                String[] fields = s.split(", ");
                return new SensorReading(fields[0],new Long(fields[1]),new Double(fields[2]));
            }
        });

        DataStream<Tuple2<String, Integer>> resultStream = dataStream.map(new MyMapper());

        resultStream.print();

        env.execute();
    }

    public static class MyMapper0 implements MapFunction<SensorReading, Tuple2<String, Integer>>{

        @Override
        public Tuple2<String, Integer> map(SensorReading value) throws Exception {
            return new Tuple2<>(value.getId(), value.getId().length());
        }
    }

    //实现自定义的富函数类
    public static class MyMapper extends RichMapFunction<SensorReading, Tuple2<String,Integer>>{ //抽象类,用extends

        @Override
        public Tuple2<String, Integer> map(SensorReading value) throws Exception {
            //获取当前运行任务的index
            return new Tuple2<>(value.getId(), getRuntimeContext().getIndexOfThisSubtask());
//            getRuntimeContext().getState();
        }

        @Override
        public void open(Configuration parameters) throws Exception {
            //初始化工作，一般是定义状态，或者建立数据库连接
            System.out.println("open");
        }

        @Override
        public void close() throws Exception {
            //一般是关闭连接和清空转态的收尾操作
            System.out.println("close");
        }
    }
}
