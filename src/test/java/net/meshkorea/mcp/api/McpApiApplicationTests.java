package net.meshkorea.mcp.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class McpApiApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void packageNameTest() {
		assertEquals("net.meshkorea.mcp.api", McpApiApplication.class.getPackage().getName());
	}

}
