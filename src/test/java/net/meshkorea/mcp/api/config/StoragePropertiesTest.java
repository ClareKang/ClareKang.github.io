package net.meshkorea.mcp.api.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by reverof on 2017. 4. 19..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StoragePropertiesTest {

    @Autowired
    StorageProperties storageProperties;

    @Test
    public void 파일_저장경로() {
        assertEquals("/tmp", storageProperties.getLocation());
    }
}
