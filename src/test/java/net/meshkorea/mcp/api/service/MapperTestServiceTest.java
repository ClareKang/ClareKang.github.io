package net.meshkorea.mcp.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by yjhan on 2017. 2. 8..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTestServiceTest {

    @Autowired
    MapperTestService mapperTestService;

    @Test
    public void test() {
        assertEquals("VROONG_DEFAULT", mapperTestService.getDeliveryClassNameByPricingPlan(4L));
    }
}
