package com.enduser.config;

import com.enduser.EnduserApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
    @KafkaListener(topics = AppConstants.LOCATION_TOPIC_NAME,groupId = AppConstants.GROUP_ID)
    public void updateLocation(String value){
        System.out.println("In "+ EnduserApplication.class+" consumer and consumed message is: "+value);
    }
}
