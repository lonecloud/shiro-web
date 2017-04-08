package cn.lonecloud.service.impl;

import cn.lonecloud.service.ShiroService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lonecloud on 17/4/7.
 */
@Service
public class ShiroServiceImpl implements ShiroService{

    private static final Log log = LogFactory.getLog(ShiroServiceImpl.class);

    /**
     * 测试shiro的Session 方法
     */
    @Override
    public void testShiro() {
        Session session = SecurityUtils.getSubject().getSession();
        Object test = session.getAttribute("test");
        log.debug(test);
    }
}
