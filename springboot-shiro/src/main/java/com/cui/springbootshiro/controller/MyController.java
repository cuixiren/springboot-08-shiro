package com.cui.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){ //Model的作用：回传参数给前端
        model.addAttribute("msg","hello,shiro");
        return "index";
    }

    @RequestMapping({"/user/add"})
    public String add(){
        return "user/add";
    }

    @RequestMapping({"/user/update"})
    public String update(){
        return "user/update";
    }

    @RequestMapping({"/toLogin"})
    public String toLogin(){
        return "login";
    }

    @RequestMapping({"/login"})
    public String login(String username, String password, Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token); //执行登录方法，无异常则ok
            return "登录成功，返回index";
        } catch (UnknownAccountException e){ //用户名不存在
            model.addAttribute("msg","用户名错误");
            return "用户名错误";
        } catch (IncorrectCredentialsException e){ //密码不存在
            model.addAttribute("msg","密码错误");
            return "密码错误";
        }
    }

    @RequestMapping({"/noauth"})
    public String unauthorised(){
        return "未经授权无法访问此页面";
    }

}
