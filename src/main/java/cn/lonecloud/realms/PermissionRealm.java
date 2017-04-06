package cn.lonecloud.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;

/**
 * 用于自定义realm
 *
 * @author lonecloud
 */
public class PermissionRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken instanceof UsernamePasswordToken) {
            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            //
            String username = token.getUsername();
            //根据用户名向数据库查询该用户名对应的user
            if ("unKnow".equals(username)) {
                throw new UnknownAccountException();
            }
            if ("lock".equals(username)) {
                throw new LockedAccountException();
            }
            String user = "root";//用户
            String password = "123";//该处获取的为数据库中获取密码
            //设置认证信息比对密码由shiro进行比对
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
            return info;
        }
        return null;
    }
}
