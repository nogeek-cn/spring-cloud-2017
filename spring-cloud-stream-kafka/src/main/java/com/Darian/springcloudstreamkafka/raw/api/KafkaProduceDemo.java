//package com.Darian.springcloudstreamkafka.raw.api;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.Properties;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
///**
// * <br>Kafka Producer Demo(使用原始的 API )
// * <br>Darian
// **/
//public class KafkaProduceDemo {
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        // 初始化配置
//        Properties properties = new Properties();
//        properties.setProperty("bootstrap.servers", "kafka.darian.com:9092");
//        properties.setProperty("key.serializer", JsonSerializer.class.getName());
//        properties.setProperty("value.serializer", StringSerializer.class.getName());
//        // 创建 Kafka Producer
//        KafkaProducer<String, String> kafkaProducer = new KafkaProducer(properties);
//        // 创建 kafka 消息 = ProducerRecord
//        String topic = "darianTest";
//        Integer partition =  0;// 分区
//        Long timestamp = System.currentTimeMillis();
//        String key = "message-key";
//        String value = "darian-name";
//        ProducerRecord<String, String> record =
//                new ProducerRecord<String, String>(topic,partition,timestamp,key,value);
//
//        // 发送 Kafka 消息
//        Future<RecordMetadata> metadataFuture = kafkaProducer.send(record);
//        // 强制执行
//        metadataFuture.get();
//    }
//}
