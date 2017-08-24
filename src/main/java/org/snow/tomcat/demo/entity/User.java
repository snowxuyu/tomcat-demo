package org.snow.tomcat.demo.entity;

import lombok.Data;
import org.framework.basic.entity.BaseEntity;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Copyright @ 2017QIANLONG.
 * All right reserved.
 * Class Name : org.snow.tomcat.demo.entity
 * Description : tomcat-demo
 * Author : gaoguoxiang
 * Date : 2017/2/8
 */
@Data
@Table(name = "t_user")
public class User extends BaseEntity {

    @NotBlank(message = "userName不能为空")
    private String userName;

    @NotBlank(message = "password不能为空")
    private String passWord;
    private String  phone;
    private String address;
}
