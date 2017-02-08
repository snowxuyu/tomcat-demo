package org.snow.tomcat.demo.service.impl;

import org.framework.basic.service.impl.BaseServiceImpl;
import org.snow.tomcat.demo.dao.UserDao;
import org.snow.tomcat.demo.entity.User;
import org.snow.tomcat.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright @ 2017QIANLONG.
 * All right reserved.
 * Class Name : org.snow.tomcat.demo.service.impl
 * Description : tomcat-demo
 * Author : gaoguoxiang
 * Date : 2017/2/8
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserDao userDao;


}
