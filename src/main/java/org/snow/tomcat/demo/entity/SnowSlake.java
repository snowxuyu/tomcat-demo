package org.snow.tomcat.demo.entity;

import lombok.Data;
import org.framework.basic.entity.BaseEntity;

import javax.persistence.Table;

/**
 * date: 2018/10/18 20:27
 * author: snowxuyu
 * describe:
 */
@Table(name = "t_snow_slake")
@Data
public class SnowSlake extends BaseEntity {
    private Long unId;
}
