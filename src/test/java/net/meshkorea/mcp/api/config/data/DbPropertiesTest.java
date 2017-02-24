package net.meshkorea.mcp.api.config.data;

import net.meshkorea.platform.core.web.config.data.MasterDbProperties;
import net.meshkorea.platform.core.web.config.data.PrimeDbProperties;
import net.meshkorea.platform.core.web.config.data.VroongDbProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by yjhan on 2017. 2. 7..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbPropertiesTest {

    @Autowired
    MasterDbProperties masterDbProperties;

    @Autowired
    VroongDbProperties vroongDbProperties;

    @Autowired
    PrimeDbProperties primeDbProperties;

    @Test
    public void test() {
        assertEquals("com.mysql.jdbc.Driver", masterDbProperties.getDriverClassName());
        assertEquals("com.mysql.jdbc.Driver", vroongDbProperties.getDriverClassName());
        assertEquals("com.mysql.jdbc.Driver", primeDbProperties.getDriverClassName());
    }
}
