package com.cui.springbootshiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean 第三步
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
         * anon：无需认证即可访问
         * authc：必须认证才可访问
         * user：必须设置记住我才可使用
         * perms：拥有对某个资源的权限才可访问
         * role：拥有某个角色权限才可访问
         *
//        filterMap.put("/user/add","anon");
//        filterMap.put("/user/update","authc");
         */
        Map<String,String> filterMap = new LinkedHashMap<>();

        //授权代码要写在拦截前面，不然上面通过下面就不认证了👇👇👇 正常情况下没有授权会跳转到未授权页面
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");

        //拦截
        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //拦截成功跳转到登录页
        bean.setLoginUrl("/toLogin");
        //未授权页面
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    //DefaultWebSecurityManager 第二步
    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象，需要自定义类 第一步
//    @Bean
//    public UserRealm userRealm(){
//        return new UserRealm();
//    }
}
