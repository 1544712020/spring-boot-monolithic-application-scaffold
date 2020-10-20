package com.lwz.web.entity;

import lombok.Data;

import java.util.List;

/**
 * MyBatisPlus分页插件使用的分页数据存储类
 * @author Lw中
 * @date 2020/9/11 18:00
 */

@Data
public class RoleVo {

    private Integer current;
    private Integer size;
    private Long total;
    private List<Role> roleList;

}
