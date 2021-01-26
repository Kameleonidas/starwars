package pl.starwars.api.client;

import feign.Logger;
import feign.Logger.Level;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Level.FULL;
    }

    @Bean
    public GsonEncoder encoder() {
        return new GsonEncoder();
    }

    @Bean
    public GsonDecoder decoder() {
        return new GsonDecoder();
    }
}
