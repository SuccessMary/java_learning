package com.atguigu.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;
import java.util.*;

public class MyConsumer {
    public static void main(String[] args) {

        //1.创建消费者配置信息
        Properties properties = new Properties();

        //2.配置信息赋值

        //连接集群
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop102:9092");
        //开启自动提交offset
//        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);

        //自动提交的延时，默认一秒自动提交一次offset
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
        //key，value的反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka" +
                ".common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka" +
                ".common.serialization.StringDeserializer");
        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"bigdata");

        //重置消费者的offset，当不存在offset初始值（offset值失效）或者换消费者组时，设置为earliest可以从头开始消费数据
        //注意：没有换组，offset就有效，上次消费到哪，offset就是多少，换组则反之
        //所以，如果想要重新消费某个topic，就可以换组+重置offset
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");//默认是latest，即不从头消费

        //3.创建消费者对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        //订阅主题
        consumer.subscribe(Arrays.asList("first","second"));

        //获取数据，注意加了s，说明会拉取多个值，即批量获取
        while (true){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);

            //所以要解析并打印consumerRecords
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key() + "--" + consumerRecord.value());

            }
        }


        //关闭连接
//        consumer.close();

    }
}
