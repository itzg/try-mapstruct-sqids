package me.itzg.trymapstructsqids.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqids.Sqids;

@Configuration
public class SqidsConfig {
    @Bean
    public Sqids sqids() {
        return Sqids.builder()
            .minLength(4)
            .build();
    }
}
