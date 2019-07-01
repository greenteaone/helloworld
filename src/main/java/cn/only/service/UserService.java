package cn.only.service;

import cn.only.entity.User;

import java.util.List;

public interface UserService {
    int insert(User record);

    List<User> selectUserByName(User record);
    User login(User record);
    int deleteByPrimaryKey (Integer id);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(User record);
}