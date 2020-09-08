package com.lwz.scaffold.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 此类用于描述用户角色
 * @author Lw中
 * @date 2020/8/26 11:44
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    /**  角色id */
    private int id;
    /**  角色英文名*/
    private String name;
    /** 角色中文名 */
    private String nameZh;

}
