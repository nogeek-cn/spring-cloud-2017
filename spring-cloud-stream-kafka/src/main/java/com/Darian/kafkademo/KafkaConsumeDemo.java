package com.Darian.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * <br>
 * <br>Darian
 **/
public class KafkaConsumeDemo extends Thread {

    private final KafkaConsumer kafkaConsumer;

    public KafkaConsumeDemo(String topic) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka.darian.com:9092");

        properties.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConsumeDemo.class.getName());
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        kafkaConsumer = new KafkaConsumer(properties);
        kafkaConsumer.subscribe(Collections.singletonList(topic));
    }

    @Override
    public void run() {
        while (true) {
            ConsumerRecords<Integer, String> consumerRecords = kafkaConsumer.poll(1000);
            consumerRecords.forEach(integerStringConsumerRecord ->
                    System.out.println("message receive:" + integerStringConsumerRecord.value())
            );
        }
    }


    public static void main(String[] args) {
        new KafkaConsumeDemo("darianTest").start();
    }
}
