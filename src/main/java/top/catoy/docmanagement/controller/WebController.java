package top.catoy.docmanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.catoy.docmanagement.domain.ResponseBean;
import top.catoy.docmanagement.domain.User;
import top.catoy.docmanagement.service.UserService;
import top.catoy.docmanagement.utils.FileDownLoadUtil;
import top.catoy.docmanagement.utils.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class WebController {

    private static final Logger LOGGER = LogManager.getLogger(WebController.class);

    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password")String password) {
        System.out.println("用户名:"+username+"密码:"+password);
        ResponseBean result = userService.Login(username,password);
        if(result.getMsg().equals("登录成功")){
            String token = JWTUtil.sign((User) result.getData(),password);
            System.out.println(JWTUtil.getUserInfo(token));
            return new ResponseBean(ResponseBean.SUCCESS, "Login success", JWTUtil.sign((User) result.getData(), password));
        }else {
            return new ResponseBean(ResponseBean.FAILURE,"登录失败",null);
        }

        //获取subject
//        Subject subject = SecurityUtils.getSubject();
//        //封装用户数据
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        try {
//            subject.login(token);
//            return new ResponseBean(200, "登入成功", null);
//        }catch (UnknownAccountException e){
//            return new ResponseBean(500, "用户名不存在", null);
//        }catch (IncorrectCredentialsException e){
//            return new ResponseBean(500, "密码错误", null);
//        }
    }

    @GetMapping("/getAllUsers")
    public ResponseBean getAllUsers(){
        ResponseBean result = userService.getAllUsers();
        System.out.println(result.getData());
        if(result.getMsg().equals("查询成功")) {
            return result;
        }else {
            return result;
        }
    }

    @GetMapping("/article")
    public ResponseBean article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ResponseBean(200, "You are already logged in", null);
        } else {
            return new ResponseBean(200, "You are guest", null);
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResponseBean requireAuth() {
        return new ResponseBean(200, "You are authenticated", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ResponseBean requireRole() {
        return new ResponseBean(200, "You are visiting require_role", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public ResponseBean requirePermission() {
        return new ResponseBean(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseBean unauthorized() {
        return new ResponseBean(401, "Unauthorized", null);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void Download(HttpServletResponse res) {
        FileDownLoadUtil.Download(res);
    }
}
