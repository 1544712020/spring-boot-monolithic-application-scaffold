package com.lwz.scaffold.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwz.scaffold.dao.RoleMapper;
import com.lwz.scaffold.entity.Role;
import com.lwz.scaffold.entity.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lw中
 * @date 2020/9/11 17:44
 */

@CacheConfig(cacheNames = "roles")
@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    /**
     *
     * @param role
     * @return
     */
    public int addRoles(Role role) {
        int i = roleMapper.addRoles(role);
        return i;
    }

    /**
     *  @Cacheable：表示该方法的返回结果需要缓存起来
     *  #p0：表示传入的第一个参数作为redis的key（使用el表达式来指定key）
     * @param uid
     * @return
     */
    @Cacheable(key = "#p0")
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<Role> getRolesByUid(int uid) {
        List<Role> roles = roleMapper.getRolesByUid(uid);
        return roles;
    }

    /**
     *
     * @param uid
     * @param roles
     * @return
     */
    public int addUserRole(int uid, String[] roles) {
        int i = roleMapper.addUserRole(uid, roles);
        return i;
    }

    /**
     * 调用的是mybatisPlus提供的删除方法
     * @param rid
     * @return
     */
    public int deleteRoleById(int rid) {
        int i = roleMapper.deleteById(rid);
        return i;
    }

    /**
     * 调用的是mybatisPlus提供的分页查询方法
     * @param current
     * @param size
     * @return
     */
    public RoleVo queryList(Integer current, Integer size) {
        RoleVo roleVo = new RoleVo();
        IPage<Role> page = new Page<>(current, size);
        roleMapper.selectPage(page, null);
        roleVo.setCurrent(current);
        roleVo.setSize(size);
        roleVo.setTotal(page.getTotal());
        roleVo.setRoleList(page.getRecords());
        return roleVo;
    }

}
