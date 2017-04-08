package cn.lonecloud.controller;

import cn.lonecloud.expection.SysException;
import cn.lonecloud.service.ShiroService;
import cn.lonecloud.utils.ShiroHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录页面
 *
 * @author lonecloud
 */
@Controller
public class LoginController {

    private static final Log log = LogFactory.getLog(LoginController.class);
    @Autowired
    ShiroService shiroService;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {
        return "/login";
    }

    /**
     * 验证登录方法
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("remember") String remember, Model model) {
        boolean isRemember = false;
        if (remember != null && "true".equals(remember)) {
            isRemember = true;
        }
        ShiroHelper shiroHelper = new ShiroHelper();
        try {
            shiroHelper.checkAuth(username, password, isRemember);
        } catch (Exception e) {
            if (e instanceof SysException) {
                String msg = ((SysException) e).getMsg();
                log.debug(msg);
                model.addAttribute("msg", msg);
            }
            return "/login";
        }
        return "redirect:/main";
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:logout";
    }

    @GetMapping("/main")
    public String main() {
        return "/main";
    }

    @GetMapping("/user")
    public String user() {
        return "/user/user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/user/admin";
    }

    @RequiresRoles("admin")
    @GetMapping("/testShiro")
    public String testShiro(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("test", "测试shiroSession和Http中的Session同步返回值");
        shiroService.testShiro();
        return "/main";
    }
}
