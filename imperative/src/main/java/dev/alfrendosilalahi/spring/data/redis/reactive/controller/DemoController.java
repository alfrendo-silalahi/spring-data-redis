package dev.alfrendosilalahi.spring.data.redis.reactive.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final RedisTemplate<String, String> redisTemplate;

    public DemoController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping
    public String setDataIntoRedis(@RequestParam String data) {
        redisTemplate.opsForValue().set("data", data);
        return String.format("Data '%s' stored on Redis", data);
    }

    @GetMapping
    public String getDataFromRedis() {
        String data = redisTemplate.opsForValue().get("data");
        return String.format("Data from Redis :: %s", data);
    }

}
