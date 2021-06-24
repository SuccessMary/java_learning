package com.atguigu.apiDemo.source;

import com.atguigu.apiDemo.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.HashMap;
import java.util.Random;

//自定义数据源
public class SourceTest4_UDF {
    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //自定义数据源：只要传入自定义的SourceFunction就可
        DataStream<SensorReading> dataStream = env.addSource(new MySensorSource());

        //打印输出
        dataStream.print();

        env.execute();
    }

    //
    public static class MySensorSource implements SourceFunction<SensorReading>{
        //定义一个标识位，用来控制数据的产生
        private boolean running = true;

        @Override
        public void run(SourceContext<SensorReading> sourceContext) throws Exception {
            ///定义一个随机数发生器
            Random random = new Random();

            ///先设置10个传感器的初始温度，存储在HashMap中
            HashMap<String, Double> sensorTempMap = new HashMap<>();
            for (int i = 0; i < 10; i++){
                sensorTempMap.put("sensor_" + (i+1),65+random.nextGaussian()*20);//随机生成高斯随机数
                // （在原来标准正太分布的基础上通过运算改变随机数的生成范围）
            }


            while (running){
                for(String sensorId:sensorTempMap.keySet()){
                    //在当前温度基础上做随机波动
                    double newTemp = sensorTempMap.get(sensorId) + random.nextGaussian();
                    //更新哈希map里的值
                    sensorTempMap.put(sensorId,newTemp);
                    sourceContext.collect(new SensorReading(sensorId,System.currentTimeMillis(),newTemp));
                }

                //控制输出频率
                Thread.sleep(1000L);
            }

        }

        @Override
        public void cancel() {
            running = false;
        }
    }


}
