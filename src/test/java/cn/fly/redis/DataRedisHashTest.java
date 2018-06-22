package cn.fly.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @program: spring-data-redis-demo
 * @description:
 * @author: Arctic_Xiong
 * @create: 2018-06-09 20:23
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-redis.xml")
public class DataRedisHashTest {
    @Autowired
    private RedisTemplate redisTemplate;

    //增加测试
    @Test
    public void testAdd(){
        redisTemplate.boundHashOps("namehash").put("a","唐僧");
        redisTemplate.boundHashOps("namehash").put("b","孙悟空");
        redisTemplate.boundHashOps("namehash").put("c","猪八戒");
        redisTemplate.boundHashOps("namehash").put("d","沙和尚");
    }
    //查询测试
    @Test
    public void testGet(){
        Set keys = redisTemplate.boundHashOps("namehash").keys();//获取所有的key
        List list = redisTemplate.boundHashOps("namehash").values();//获取所有的值
        System.out.println(keys);
        System.out.println(list);
    }
    /***
     * 根据key提取值
     */
    @Test
    public void testGetValueByKey(){
        Object object = redisTemplate.boundHashOps("itemCat").get("手机");
        System.out.println(object);
    }

    /****
     * 根据key移除值
     */
    @Test
    public void testRemoveValueByKey(){
        redisTemplate.boundHashOps("BrandList").delete();
    }
}