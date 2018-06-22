package cn.fly.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: spring-data-redis-demo
 * @description: 值类型
 * @author: Arctic_Xiong
 * @create: 2018-06-09 20:01
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-redis.xml")
public class DataRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 增加数据测试
     */
    @Test
    public void testSetValue(){
        redisTemplate.boundValueOps("name").set("itcast");
    }

    /**
     * 查询数据
     */
    @Test
    public void testGetValue(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    /**
     * 删除数据
     */
    @Test
    public void testDeleteValue(){
        redisTemplate.delete("name");
    }
}