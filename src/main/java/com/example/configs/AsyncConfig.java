package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync // @Async anotasyonu ile çalışan metotlar için destek açılır
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // Minimum thread sayısı (CPU core sayısına göre ayarlanmalı)
        executor.setCorePoolSize(10);

        // Maksimum thread sayısı (beklenen eşzamanlı istek sayısına göre)
        executor.setMaxPoolSize(50);

        // Thread kuyruğu kapasitesi
        executor.setQueueCapacity(100);

        // Thread isim prefix’i (loglarda kolay ayırt etmek için)
        executor.setThreadNamePrefix("Async-");

        // Reddedilen task’lar için strateji (burada CallerRunsPolicy seçildi)
        // Eğer havuz doluysa, task çağıran thread üzerinde çalıştırılır
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();
        return executor;
    }
}
