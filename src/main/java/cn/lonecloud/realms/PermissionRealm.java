package cn.lonecloud.realms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 用于自定义
 * 认证realm   继承AuthenticatingRealm
 * AuthorizingRealm授权和认证class
 *
 * @author lonecloud
 */
public class PermissionRealm extends AuthorizingRealm {

    private static final Log log = LogFactory.getLog(PermissionRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("单独一个realm--------->PermissionRealm");
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
        String password = "0224ec7377460a7ecbebe189981ec8b9";//该处获取的为数据库中获取密码
        if ("user".equals(username)) {
            password = "c8c31ed2511a05007565caf960bfc004";
        }
        ByteSource salt = ByteSource.Util.bytes(username);//使用盐值保证密码的唯一性一般唯一的使用ID或者用户登录名
        //设置认证信息比对密码由shiro进行比对
//            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        //SimpleAuthenticationInfo(可以放入user对象)
        return new SimpleAuthenticationInfo(username, password, salt, getName());
    }

    /**
     * 授权方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //首先先获取用户的信息
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        Set<String> roles = new HashSet<>();
        roles.add("users");
        //判断是否有权限
        if (primaryPrincipal.equals("admin")) {
            roles.add("admin");
        }
        //返回权限
        return new SimpleAuthorizationInfo(roles);
    }
}
