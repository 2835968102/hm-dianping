package com.hmdp;

import com.hmdp.service.impl.ShopServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HmDianPingApplicationTests {
    @Autowired
    private ShopServiceImpl shopServiceImpl;

    @Test
    public void testSaveShop(){
        shopServiceImpl.saveShop2Redis(1L,10L);
        shopServiceImpl.saveShop2Redis(2L,10L);
        shopServiceImpl.saveShop2Redis(3L,10L);
        shopServiceImpl.saveShop2Redis(4L,10L);
        shopServiceImpl.saveShop2Redis(5L,10L);
    }

}
