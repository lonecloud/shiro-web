package cn.lonecloud.factory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lonecloud on 17/4/7.
 * 用于对shiro 的FilterChainDefinition的工厂对象
 */
public class FilterChainDefinitionFactory {

    /**
     * 创建FilterChainDefinition对象
     *  1.anon 匿名访问
     *  2.authc 认证访问
     *  3.logout 登出
     *  4.user 可以通过remberme 访问或者认证访问
     * @return
     */
    public Map<String, String> buildFilterChainDefinition() {
        //在这里进行对数据库的查询返回一个LinkedHashMap
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/login", "anon");
        map.put("/doLogin", "anon");
        map.put("/logout", "logout");
        map.put("/assert/*", "anon");
        map.put("/admin", "roles[admin]");
        map.put("/user", "roles[users]");
        map.put("/main","user");
        map.put("/**", "authc");
        return map;
    }
}
