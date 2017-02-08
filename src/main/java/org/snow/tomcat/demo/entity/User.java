package org.snow.tomcat.demo.entity;

import lombok.Data;
import org.framework.basic.entity.BaseEntity;

import javax.persistence.Table;

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

    private String userName;
    private String passWord;
    private String  phone;
    private String address;
}
