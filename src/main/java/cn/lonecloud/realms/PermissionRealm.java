package cn.lonecloud.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

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
            String password = "0224ec7377460a7ecbebe189981ec8b9";//该处获取的为数据库中获取密码
            ByteSource salt= ByteSource.Util.bytes(username);//使用盐值保证密码的唯一性一般唯一的使用ID或者用户登录名
            //设置认证信息比对密码由shiro进行比对
//            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,salt,getName());
            return info;
        }
        return null;
    }
}
