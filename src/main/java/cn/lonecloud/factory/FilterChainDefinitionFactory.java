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
     *
     * @return
     */
    public LinkedHashMap<String, String> buildFilterChainDefinition() {
        //在这里进行对数据库的查询返回一个LinkedHashMap
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login", "anno");
        map.put("/doLogin", "anno");
        map.put("/logout", "logout");
        map.put("/assert/*", "anon");
        map.put("/admin", "roles[admin]");
        map.put("/user", "roles[users]");
        map.put("/**", "authc");
        return map;
    }
}
