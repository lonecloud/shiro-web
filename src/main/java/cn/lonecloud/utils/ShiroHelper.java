package cn.lonecloud.utils;

import cn.lonecloud.expection.SysException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;

/**
 * Created by lonecloud on 17/4/4.
 */
public class ShiroHelper {

    private Subject currentUser = SecurityUtils.getSubject();

    /**
     * 确定认证信息
     * @param username
     * @param password
     * @return
     */
    public Subject checkAuth(String username, String password) {
        boolean authenticated = currentUser.isAuthenticated();
        if (!authenticated) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                throw new SysException("用户名" + token.getPrincipal() + "出错");
            } catch (IncorrectCredentialsException ice) {
                throw new SysException("你的账户名" + token.getPrincipal() + "是不正确的!");
            } catch (LockedAccountException lae) {
                throw new SysException("你的账户名" + token.getPrincipal() + "处于锁住的!");
            } catch (AuthenticationException ace) {
                throw new SysException("密码错误");
            }
        }
        return currentUser;
    }

    /**
     * 登出
     */
    public void logout(){
        if (currentUser.isAuthenticated()){
            currentUser.logout();
        }
    }
}
