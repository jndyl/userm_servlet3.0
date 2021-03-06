package com.cs.service;

import com.cs.entity.User;

import java.util.List;

public interface UserService {

    //查询数据的总记录数
    public int findByCountUser() throws Exception;

    //分页方法
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception;

    //添加方法
    public void addUser(User user) throws Exception;

    //查询方法
    public User queryUser(int id) throws Exception;

    //修改用户
    public void updateUser(User user) throws Exception;
}
