package cn.lonecloud.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

/**
 * 用于自定义realm
 * @author lonecloud
 *
 */
public class PermissionRealm implements Realm {

    private  static  final String CLASSNAME="PermssionRealm";
    @Override
    public String getName() {
        return CLASSNAME;
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return false;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
