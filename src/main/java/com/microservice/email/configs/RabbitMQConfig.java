package com.microservice.email.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.email.name}")
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue,true);
    }

    // Este bean configura o conversor de mensagens do RabbitMQ para usar JSON.
    // Ele permite que objetos Java sejam automaticamente serializados e desserializados para/desde JSON
    // ao serem enviados ou recebidos por filas, facilitando a comunicação entre serviços.
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }


}
