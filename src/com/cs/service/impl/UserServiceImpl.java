package com.cs.service.impl;

import com.cs.dao.impl.UserDaoImpl;
import com.cs.entity.User;
import com.cs.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl udi=new UserDaoImpl();
    @Override
    public int findByCountUser() throws Exception {
        return udi.findByCountUser();
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        return udi.findByPageUserInfo(pageNo,pageSize);
    }

    @Override
    public void addUser(User user) throws Exception {
        udi.addUser(user);
    }

    @Override
    public User queryUser(int id) throws Exception {
        return udi.queryUser(id);
    }

    @Override
    public void updateUser(User user) throws Exception {
        udi.updateUser(user);
    }
}
