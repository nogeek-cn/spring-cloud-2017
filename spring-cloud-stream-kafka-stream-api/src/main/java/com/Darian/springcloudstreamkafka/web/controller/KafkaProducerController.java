package com.Darian.springcloudstreamkafka.web.controller;

import com.Darian.springcloudstreamkafka.stream.message.DarianMessageSource;
import com.Darian.springcloudstreamkafka.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.core.AbstractDestinationResolvingMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * <br>Darian
 **/
@RestController
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String topic;

    private final MessageProducerBean messageProducerBean;


    @Autowired
    public KafkaProducerController(
            KafkaTemplate<String, String> kafkaTemplate,
            @Value("${kafka.topic}") String topic, MessageProducerBean messageProducerBean) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
        this.messageProducerBean = messageProducerBean;
    }

    /**
     * 通过 KafkaTemplete 发送
     * <br>Darian
     **/
    @PostMapping("/message/send")
    public boolean sendMessage(@RequestParam String message) {
        kafkaTemplate.send(topic, message);
        return true;
    }

    /**
     * 通过 {@link MessageProducerBean} 发送
     * <br>Darian
     **/
    @GetMapping("/message/send")
    public boolean send(@RequestParam String message) {
        messageProducerBean.send(message);
        return true;
    }

    @GetMapping("/message/sendToDarian2")
    public boolean sendToDarian2(@RequestParam String message){
        messageProducerBean.sendToDarian(message);
        return true;
    }


}
