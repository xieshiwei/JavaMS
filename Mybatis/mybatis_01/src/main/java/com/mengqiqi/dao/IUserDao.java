package com.mengqiqi.dao;

import com.mengqiqi.entitis.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
