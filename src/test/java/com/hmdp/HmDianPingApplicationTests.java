package com.hmdp;

import com.hmdp.service.impl.ShopServiceImpl;
import com.hmdp.utils.RedisIdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HmDianPingApplicationTests {
    @Autowired
    private ShopServiceImpl shopServiceImpl;

    @Autowired
    private RedisIdWorker redisIdWorker;

    // 缓存预热
    @Test
    public void testSaveShop(){
        shopServiceImpl.saveShop2Redis(1L,10L);
        shopServiceImpl.saveShop2Redis(2L,10L);
        shopServiceImpl.saveShop2Redis(3L,10L);
        shopServiceImpl.saveShop2Redis(4L,10L);
        shopServiceImpl.saveShop2Redis(5L,10L);
    }

    ExecutorService es = Executors.newFixedThreadPool(300);
    @Test
    public void testIdWorker() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(300);

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                long id = redisIdWorker.nextId("order");
                System.out.println("id = " + id);
            }
            latch.countDown();
        };
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 300; i++) {
            es.submit(task);
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - begin));
    }

}
