package com.coffee.demo.mybatisplus;

import com.coffee.demo.mybatisplus.pojo.User;
import com.coffee.demo.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
@Slf4j
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){

        //简单测试 计算数据总行数
        long count = userService.count();
        System.err.println("数据总行数: " + count);

    }

    @Test
    public void testSave(){
        //测试多行插入数据
        //遍历插入多条数据
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("Coffee0"+i);
            user.setAge(20 + i);
            user.setEmail(user.getName()+"@163.com");
            users.add(user);
        }
        userService.saveBatch(users);
    }

}
