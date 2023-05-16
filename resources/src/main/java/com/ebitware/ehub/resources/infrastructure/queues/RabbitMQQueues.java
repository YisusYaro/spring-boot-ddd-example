package com.ebitware.ehub.resources.infrastructure.queues;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueues {

    @Bean
    public Queue resourceCreatedQueue() {
        return new Queue("resourceCreated");
    }

}
