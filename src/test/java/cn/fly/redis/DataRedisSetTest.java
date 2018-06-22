package cn.fly.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @program: spring-data-redis-demo
 * @description: set类型
 * @author: Arctic_Xiong
 * @create: 2018-06-09 20:06
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-redis.xml")
public class DataRedisSetTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 增加测试
     */
    @Test
    public void testAdd(){
        redisTemplate.boundSetOps("nameset").add("曹操");
        redisTemplate.boundSetOps("nameset").add("刘备");
        redisTemplate.boundSetOps("nameset").add("孙权");
    }

    /**
     * 查询测试
     */
    @Test
    public void testGet(){
        Set members = redisTemplate.boundSetOps("nameset").members();
        System.out.println(members);

    }
    /**
     * 删除测试
     */
    @Test
    public void testDelete(){
//        redisTemplate.boundSetOps("nameset").remove("孙权");
        redisTemplate.delete("nameset");//删除全部
    }

}