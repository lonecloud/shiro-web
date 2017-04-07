package cn.lonecloud.realms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * 用于自定义realm
 *
 * @author lonecloud
 */
public class SHA1Realm extends AuthenticatingRealm {

    private static final Log log= LogFactory.getLog(SHA1Realm.class);
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken instanceof UsernamePasswordToken) {
            log.debug("第二个Relam------>SHA1Realm");
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
            String password = "3db389fc6ecff401a4d0633d12d5c1a961d7e014";//该处获取的为数据库中获取密码
            ByteSource salt= ByteSource.Util.bytes(username);//使用盐值保证密码的唯一性一般唯一的使用ID或者用户登录名
            //设置认证信息比对密码由shiro进行比对
//            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
            return new SimpleAuthenticationInfo(username,password,salt,getName());
        }
        return null;
    }
}
