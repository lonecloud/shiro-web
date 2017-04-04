package cn.lonecloud.controller;

import cn.lonecloud.expection.SysException;
import cn.lonecloud.utils.ShiroHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录页面
 * @author lonecloud
 */
@Controller
public class LoginController {
    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {
        return "/login";
    }

    /**
     * 验证登录方法
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/dologin")
    @PostMapping
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        ShiroHelper shiroHelper=new ShiroHelper();
        try {
            shiroHelper.checkAuth(username,password);
        }catch (Exception e){
            if (e instanceof SysException){
                System.out.println(((SysException) e).getMsg());
            }
        }
        return "redirect:/main";
    }
}
