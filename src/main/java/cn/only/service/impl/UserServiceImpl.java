package cn.only.service.impl;
import cn.only.dao.UserMapper;
import cn.only.entity.User;
import cn.only.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  UserServiceImpl implements  UserService{
    @Autowired
    private UserMapper mapper;
    public  int insert(User record){return mapper.insert(record);}
    public List<User> selectUserByName(User record){return mapper.selectUserByName(record);}
    public User login(User record){return mapper.login(record);}
    public int deleteByPrimaryKey(Integer id){return mapper.deleteByPrimaryKey(id);}
    public User selectByPrimaryKey(Integer id){return  mapper.selectByPrimaryKey(id);}
    public int updateByPrimaryKey(User record){return mapper.updateByPrimaryKey(record);}
}