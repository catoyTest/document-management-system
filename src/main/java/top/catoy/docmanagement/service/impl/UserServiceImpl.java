package top.catoy.docmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.catoy.docmanagement.domain.ResponseBean;
import top.catoy.docmanagement.domain.User;
import top.catoy.docmanagement.domain.UserGroup;
import top.catoy.docmanagement.mapper.UserGroupMapper;
import top.catoy.docmanagement.mapper.UserMapper;
import top.catoy.docmanagement.service.UserService;

import java.util.List;

/**
 * @description:
 * @author: xjn
 * @create: 2019-04-26 16:14
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private UserGroupMapper userGroupMapper;


    @Override
    public User getUserByName(String userName) {
        try {
            System.out.println(userMapper.getUserByName(userName));
            User user = userMapper.getUserByName(userName);


            return userMapper.getUserByName(userName);
        }catch (RuntimeException r){
            r.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseBean getAllUsers() {
        PageHelper.startPage(1, 1);
        List<User> users = userMapper.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        if(users!=null && users.size()>0){
            return new ResponseBean(ResponseBean.SUCCESS,"查询成功",pageInfo);
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"查询失败",null);
        }
    }

    @Override
    public ResponseBean Login(String username, String password) {

        User user = userMapper.getUserByName(username);
        System.out.println("==============================="+user);
        System.out.println("-------------------"+user.getGroupId());

        if(user != null){
            if(user.getUserPassword().equals(password)){
                UserGroup userGroup = userGroupMapper.getUserGroupById(user.getGroupId());
                System.out.println(userGroupMapper+"-------------------------------");
                User userInfo = new User();
                userInfo.setUserName(user.getUserName());
                userInfo.setUserPassword(user.getUserPassword());
                userInfo.setUserLock(user.getUserLock());
                userInfo.setRole(userGroup.getGroupName());
                System.out.println(userGroup.getGroupName());
                userInfo.setPermission(userGroup.getGroupPermission());
                return new ResponseBean(ResponseBean.SUCCESS,"登录成功",userInfo);
            }else {
                return new ResponseBean(ResponseBean.FAILURE,"密码错误",null);
            }
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"用户不存在",null);
        }
    }
}
