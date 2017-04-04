package cn.lonecloud.test;

import cn.lonecloud.utils.ShiroHelper;
import org.apache.shiro.mgt.SecurityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;

/**
 * Created by lonecloud on 17/4/4.
 */
//@Transactional
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-shiro-test.xml"})
public class ShiroTest {
    @Resource
    SecurityManager securityManager;

    @Test
    public void help() throws InterruptedException {
        System.out.println(securityManager);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ShiroHelper shiroHelper = new ShiroHelper();
                    shiroHelper.checkAuth("123", "123");
                    System.out.println("1213");
                }
            };
            Thread thread=new Thread(runnable);
            thread.start();
            thread.sleep(1000);
        }

    }
}
