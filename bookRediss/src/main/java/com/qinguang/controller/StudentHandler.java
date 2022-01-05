package com.qinguang.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qinguang.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zam
 * @date 2021/12/23 -17:12
 */
@RestController
public class StudentHandler {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //添加/修改Redis数据
    @PostMapping("/set")
    public void set(@RequestBody Book book) {
        System.out.println("创建git新分支");
        System.out.println("创建git新分支test1");
        System.out.println("测试ssh");
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        HashOperations operations_hash = redisTemplate.opsForHash();
        ListOperations listOperations = redisTemplate.opsForList();
        operations_hash.put("keyhash", "hashkey", "hashvalue");
        Object o = operations_hash.get("keyhash", "hashkey");
        System.out.println("operations_hash========" + o);
        List<String> stringList = new ArrayList<>();
        stringList.add("111");
        stringList.add("222");
        stringList.add("333");
        stringList.add("444");
        stringList.add("555");
        listOperations.leftPushAll("keylist", stringList);
        List keylist1 = listOperations.range("keylist", 0, -1);
        System.out.println("range=====keylist===" + keylist1);
        Object keylist = listOperations.index("keylist", 1);
        System.out.println("index====keylist====" + keylist);

        SetOperations setOperations = redisTemplate.opsForSet();

        setOperations.add("keyset", "aaa");
        setOperations.add("keyset", "bbb");
        setOperations.add("keyset", "ccc");
        Set keyset = setOperations.members("keyset");
        System.out.println("keyset======" + keyset);

        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("keyzset", "sss", 1.0);
        zSetOperations.add("keyzset", "www", 2.0);
        zSetOperations.add("keyzset", "eee", 3.0);
        Set keyzset = zSetOperations.range("keyzset", 0, -1);
        System.out.println("keyzset=======" + keyzset);
        //operations.set("hello","world");

        //String hello = operations.get("hello");
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        //redisTemplate.afterPropertiesSet();
        //ValueOperations<String,Object> operations1=redisTemplate.opsForValue();
        //operations1.set("book", book);
    }

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 根据key获取Redis中的对象
     *
     * @param key
     * @return
     */
    @GetMapping("/get/{key}")
    public Book get(@PathVariable("key") String key) {
        return (Book) redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据key删除Redis中的对象
     *
     * @param key
     * @return
     */
    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable("key") String key) {
        redisTemplate.delete(key);
        return redisTemplate.hasKey(key);
    }
}