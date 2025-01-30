package com.example.demo.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class DemoService {

    private final RedisTemplate<String, String> redisTemplate;

    public DemoService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveToRedis(String key, String value) {
        redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(10)); // 10분 유지
    }

    public String getFromRedis(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}