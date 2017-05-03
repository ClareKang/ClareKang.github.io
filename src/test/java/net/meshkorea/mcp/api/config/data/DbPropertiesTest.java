package net.meshkorea.mcp.api.config.data;

import net.meshkorea.platform.core.web.config.data.AuthDbProperties;
import net.meshkorea.platform.core.web.config.data.MasterDbProperties;
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
    AuthDbProperties authDbProperties;

    @Test
    public void 데이터베이스_프로퍼티_로딩() {
        assertEquals("com.mysql.jdbc.Driver", masterDbProperties.getDriverClassName());
        assertEquals("com.mysql.jdbc.Driver", authDbProperties.getDriverClassName());
    }
}
