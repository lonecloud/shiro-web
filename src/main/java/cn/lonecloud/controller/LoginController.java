package cn.lonecloud.controller;

import cn.lonecloud.expection.SysException;
import cn.lonecloud.utils.ShiroHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录页面
 *
 * @author lonecloud
 */
@Controller
public class LoginController {

    private static final Log log = LogFactory.getLog(LoginController.class);

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
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        ShiroHelper shiroHelper = new ShiroHelper();
        try {
            shiroHelper.checkAuth(username, password);
        } catch (Exception e) {
            if (e instanceof SysException) {
                String msg = ((SysException) e).getMsg();
                log.debug(msg);
                model.addAttribute("msg",msg);
            }
            return "/login";
        }
        return "redirect:/main";
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        return "redirect:logout";
    }

}
