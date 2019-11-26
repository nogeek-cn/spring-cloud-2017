package com.Darian.springcloudstreamRabbitmq.web.controller;


import com.Darian.springcloudstreamRabbitmq.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>RabbitMq 消息
 * <br>Darian
 **/
@RestController
public class RabbitMqProducerController {


    private final String topic;

    private final MessageProducerBean messageProducerBean;


    @Autowired
    public RabbitMqProducerController(
            @Value("${kafka.topic}") String topic, MessageProducerBean messageProducerBean) {
        this.topic = topic;
        this.messageProducerBean = messageProducerBean;
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
