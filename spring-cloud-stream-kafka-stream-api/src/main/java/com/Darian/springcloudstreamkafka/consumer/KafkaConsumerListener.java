package com.Darian.springcloudstreamkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <br>Darian
 **/
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics ="${kafka.topic}")
    public void onMessage(String message) {
        System.out.println("Kafka 消费者监听器，darian,接收到消息：" + message);

    }

    @KafkaListener(topics ="${kafka.topic-darian}")
    public void onDarianMessage(String message) {
        System.out.println("Kafka 消费者监听器，darian2,接收到消息：" + message);

    }
}
