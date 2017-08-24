package org.snow.tomcat.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snow.tomcat.demo.entity.User;
import org.snow.tomcat.demo.service.UserService;
import org.snow.tomcat.demo.validate.Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
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
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @RequestMapping(value = "/test")
    public ResponseEntity test() {
        List<User> userList = userService.getAll();
        return BaseResponse.buildSuccess(userList, "查询成功");
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        Validator.checkValidate(bindingResult); //校验参数
        logger.debug("into addUser params:{}", JSONObject.toJSON(user));

        userService.insert(user);
        return BaseResponse.buildSuccess("添加用户成功");
    }
}
