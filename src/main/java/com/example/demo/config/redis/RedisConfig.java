package com.example.demo.config.redis;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@AllArgsConstructor
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
