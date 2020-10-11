package com.cs.dao.impl;

import com.cs.basedao.BaseDao;
import com.cs.dao.UserDao;
import com.cs.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int findByCountUser() throws Exception {
        int index = 0;
        String sql = "select Count(*) from user";
        ResultSet rs = exeuQuery(sql, null);
        while (rs.next()) {
            index = rs.getInt(1);
        }
        getClose();
        return index;
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        List<User> list = new ArrayList<User>();
        String sql = "select * from user limit ?,?";
        Object obj[] = {(pageNo - 1) * pageSize, pageSize};
        ResultSet rs = exeuQuery(sql, obj);
        while (rs.next()) {
            User us = new User();
            us.setId(rs.getInt(1));
            us.setPassword(rs.getString(2));
            us.setUsername(rs.getString(3));
            us.setSex(rs.getString(4));
            us.setBornDate(rs.getTimestamp(5));
            us.setUserpic(rs.getString(6));
            list.add(us);
        }
        getClose();
        return list;
    }

    @Override
    public void addUser(User user) throws Exception {
        String sql = "insert into user(username,password,sex,borndate) value(?,?,?,?)";
        exeuUpdate(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getBornDate());
    }

    @Override
    public User queryUser(int id) throws Exception {
        String sql = "select * from user where id = ?";
        ResultSet rs = exeuQuery(sql, id);
        User us = null;
        while (rs.next()) {
            us = new User();
            us.setId(rs.getInt(1));
            us.setPassword(rs.getString(2));
            us.setUsername(rs.getString(3));
            us.setSex(rs.getString(4));
            us.setBornDate(rs.getTimestamp(5));
            us.setUserpic(rs.getString(6));
        }
        return us;
    }

    @Override
    public void updateUser(User user) throws Exception {
        String sql = "update user set username = ?,password = ?,sex= ? ,borndate = ? where id = ?";
        exeuUpdate(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getBornDate(), user.getId());
    }
}
