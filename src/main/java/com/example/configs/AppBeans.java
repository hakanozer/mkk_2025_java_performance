package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class AppBeans {

    @Bean
    public Map<String, Object> getConfig() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1); // id -> hascode
        map.put("name", "John");
        return map;
    }

    @Bean
    public Map<String, Object> getConfigX() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1); // id -> hascode
        map.put("name", "John");
        return map;
    }

}
