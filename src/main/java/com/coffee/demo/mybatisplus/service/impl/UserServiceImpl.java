package com.coffee.demo.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coffee.demo.mybatisplus.mapper.UserMapper;
import com.coffee.demo.mybatisplus.pojo.User;
import com.coffee.demo.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
