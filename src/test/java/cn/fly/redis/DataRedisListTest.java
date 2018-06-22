package cn.fly.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: spring-data-redis-demo
 * @description:
 * @author: Arctic_Xiong
 * @create: 2018-06-09 20:12
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-redis.xml")
public class DataRedisListTest {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 增加测试
     * 右压栈：后添加的对象排在后边
     */
    @Test
    public void testRightAdd(){
        redisTemplate.boundListOps("namelist1").rightPush("刘备");
        redisTemplate.boundListOps("namelist1").rightPush("关羽");
        redisTemplate.boundListOps("namelist1").rightPush("张飞");
    }
    //查询
    @Test
    public void testGetRight(){
        List list = redisTemplate.boundListOps("namelist1").range(0, 10);
        System.out.println(list);
    }

    //增加测试   左压栈：后添加的对象排在左边
    @Test
    public void testLeftAdd(){
        redisTemplate.boundListOps("namelist2").leftPush("刘备");
        redisTemplate.boundListOps("namelist2").leftPush("关羽");
        redisTemplate.boundListOps("namelist2").leftPush("张飞");
    }

    //查询
    @Test
    public void testGetLeft(){
        List list = redisTemplate.boundListOps("namelist2").range(0, 10);
        System.out.println(list);
    }

    /**
     * 根据索引查询集合某个元素 索引从0开始
     */
    @Test
    public void testSearchByIndex(){
        String s = (String) redisTemplate.boundListOps("namelist1").index(0);
        System.out.println(s);
    }
    /**
     * 移除集合某个元素
     */
    @Test
    public void testRemoveByIndex(){
//        redisTemplate.boundListOps("namelist2").remove(1, "关羽");
        redisTemplate.delete("namelist2");
    }
}