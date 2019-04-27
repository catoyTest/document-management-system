package top.catoy.docmanagement.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.catoy.docmanagement.config.exception.UnauthorizedException;
import top.catoy.docmanagement.domain.ResponseBean;
import top.catoy.docmanagement.domain.User;
import top.catoy.docmanagement.service.UserService;
import top.catoy.docmanagement.utils.JWTUtil;

@RestController
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password")String password) {

        User user = userService.getUserByName(username);
        if(user == null){
            return new ResponseBean(200, "没有该用户", null);
        }else {
            if (user.getUserPassword().equals(password)) {
                return new ResponseBean(200, "Login success", JWTUtil.sign(username, password));
            } else {
                throw new UnauthorizedException();
            }
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
}
