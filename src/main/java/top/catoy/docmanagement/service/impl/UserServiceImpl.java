package top.catoy.docmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.catoy.docmanagement.domain.User;
import top.catoy.docmanagement.mapper.UserMapper;
import top.catoy.docmanagement.service.UserService;

/**
 * @description:
 * @author: xjn
 * @create: 2019-04-26 16:14
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByName(String userName) throws RuntimeException{
        try {
            System.out.println(userMapper.getUserByName(userName));
            return userMapper.getUserByName(userName);
        }catch (RuntimeException r){
            return null;
        }
    }
}
