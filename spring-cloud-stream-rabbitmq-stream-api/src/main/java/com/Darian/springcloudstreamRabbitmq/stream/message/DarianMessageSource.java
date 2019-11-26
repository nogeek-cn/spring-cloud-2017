package com.Darian.springcloudstreamRabbitmq.stream.message;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


/**
 * <br>
 * <br>Darian
 **/
public interface DarianMessageSource {

    /**
     * 消息来源的管道名称：“darian”
     **/
    String Name = "darian";

    @Output(Name)
    MessageChannel messageChannel();


}
