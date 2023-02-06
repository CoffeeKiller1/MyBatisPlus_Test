package com.coffee.demo.mybatisplus;

import com.coffee.demo.mybatisplus.mapper.UserMapper;
import com.coffee.demo.mybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@SpringBootTest
@Slf4j
class MybatisplusApplicationTests {


    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //查询集合测试
        List<User> users = userMapper.selectList(null);
        users.forEach(System.err::println);

        //根据id查询用户
        /*User user = userMapper.selectById(4L);
        System.out.println("查询的用户是: " + user);*/

        //根据多个id查询用户
        /*List<Long> list = Arrays.asList(4L, 5L, 1L);
        List<User> userList = userMapper.selectBatchIds(list);
        userList.forEach(System.err::println);*/

        //使用条件查询数据
        //map 键值对匹配方式查询
        /*HashMap<String, Object> map = new HashMap<>();
        map.put("age",28);
        List<User> select = userMapper.selectByMap(map);
        select.forEach(System.err::println);*/

    }

    @Test
    public void testInsert(){
        //简单插入测试
        User user = new User();
        user.setName("咖啡");
        user.setAge(20);
        user.setEmail("23333@qq.com");

        int result = userMapper.insert(user);

        log.info("影响行数: {}",result);
    }


    @Test
    public void testDelete(){
        //简单删除测试
        //通过id删除一位用户
        /*int result = userMapper.deleteById(1622247237783212034L);
        */

        //批量删除用户
        //使用list集合 遍历方式
        /*List list = Arrays.asList(1L,2L,3L);
        int result = userMapper.deleteBatchIds(list);
        */

        //根据条件删除用户
        //使用map集合 键值对匹配方式
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","咖啡");
        map.put("age",20);
        int result = userMapper.deleteByMap(map);

        log.info("影响行数: {}",result);
    }

    @Test
    public void testUpdate(){

        //简单修改测试
        //传入一个全新对象,进行修改
        User user = new User(4L,"张无忌",21,"zhangwuji@qq.com",0L);
        int result = userMapper.updateById(user);

        log.warn("影响行数: {}",result);
    }


}
