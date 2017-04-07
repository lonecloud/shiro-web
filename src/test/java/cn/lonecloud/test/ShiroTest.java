package cn.lonecloud.test;

import cn.lonecloud.utils.ShiroHelper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.Transient;

/**
 * Created by lonecloud on 17/4/4.
 */
//@Transactional
@RunWith(value = SpringJUnit4ClassRunner.class)//Spring自动化测试
@ContextConfiguration({"classpath:applicationContext-shiro-test.xml"})//加载测试化文件
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
    @Test
    public void MD5Lock(){
        String lockName="MD5";//加密算法
        String source="1234";//原密码
        Object salt=ByteSource.Util.bytes("admin");
        //盐值:使得相同的密码但是加密后的密码变成不同使用这个方法获取ByteSource.Util.bytes("admin")
        int count=10;//MD5加密次数
        SimpleHash md5 = new SimpleHash(lockName,source,salt,count);
        System.out.println(md5);
    }
}
