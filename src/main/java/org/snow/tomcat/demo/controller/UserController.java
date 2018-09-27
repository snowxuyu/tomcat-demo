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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
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

    @RequestMapping("/testObj")
    public ResponseEntity testObj() {
        List list = new ArrayList();
        return BaseResponse.buildSuccess(list, "查询");
    }

    @RequestMapping(value = "/getAll")
    public ResponseEntity getAll() {
        List<User> userList = userService.getAll();
        return BaseResponse.buildSuccess(userList, "查询成功");
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        Validator.checkValidate(bindingResult);
        logger.debug("into addUser params:{}", JSONObject.toJSON(user));

        userService.insert(user);
        return BaseResponse.buildSuccess("添加用户成功");
    }

    @PostMapping(value = "/updateUser", consumes = "application/json")
    public ResponseEntity updateUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        Validator.checkValidate(bindingResult);
        logger.debug("update user info:{}", JSONObject.toJSON(user));
        User entity = userService.getById(user.getId());
        entity.setUserName(user.getUserName());
        entity.setPassWord(user.getPassWord());
        entity.setAddress(user.getAddress());
        entity.setPhone(user.getPhone());
        userService.update(entity);
        return BaseResponse.buildSuccess("用户修改成功");
    }

    @PostMapping(value = "/delete/{id}", consumes = "application/json")
    public ResponseEntity updateUser(@PathVariable("id") String id) {
        userService.deleteById(id);
        return BaseResponse.buildSuccess("用户删除成功");
    }

    @GetMapping(value = "/getByObj")
    public ResponseEntity getByObj() {
        User user = new User();
        user.setPhone("18621982087");
        List<User> userList = userService.getByObj(user);
        return BaseResponse.buildSuccess(userList, "查询成功");
    }

    @GetMapping(value = "/getOne")
    public ResponseEntity getOne() {
        User user = new User();
        user.setPhone("18621982087");
        User one = userService.getOneByObj(user);
        return BaseResponse.buildSuccess(one, "查询成功");
    }

}
