package org.snow.tomcat.demo.controller;

import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.snow.tomcat.demo.entity.User;
import org.snow.tomcat.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright @ 2017QIANLONG.
 * All right reserved.
 * Class Name : org.snow.tomcat.demo.contrtoller
 * Description : tomcat-demo
 * Author : gaoguoxiang
 * Date : 2017/2/8
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/test")
    public ResponseEntity test() {
        List<User> userList = userService.getAll();
        return BaseResponse.buildSuccess(userList, "查询成功");
    }
}
