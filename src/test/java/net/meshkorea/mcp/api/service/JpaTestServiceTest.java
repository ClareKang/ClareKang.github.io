package net.meshkorea.mcp.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by yjhan on 2017. 2. 6..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTestServiceTest {

    @Autowired
    private JpaTestService jpaTestService;

    @Test
    public void test() {
        String className = jpaTestService.getDeliveryClassCode(4L);
        System.out.println(className);
        assertEquals("VROONG_DEFAULT", className);
    }
}
