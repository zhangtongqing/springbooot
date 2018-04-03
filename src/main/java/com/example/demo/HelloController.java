package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/2.
 */
@RestController
@EnableAutoConfiguration


public class HelloController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    DemoService demoService;

    @RequestMapping("/hello")
    public String say() {
        System.out.println("Hello springboot");
        return "你好，这是一个springboot 例子";
    }

    @RequestMapping("/getName")
    public String setValue(){
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set("name", "zhang");
        Object obj = operations.get("name");
        return obj.toString();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String putCache(){
        demoService.findUser(1l,"wang","yunfei");
        demoService.findAddress(1l,"anhui","hefei");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return "ok";
    }
}
