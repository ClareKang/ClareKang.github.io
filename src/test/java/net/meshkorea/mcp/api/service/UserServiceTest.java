package net.meshkorea.mcp.api.service;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.service.auth.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by reverof on 2017. 6. 13..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void 유저_생성_삭제() {
//        User user = new User();
//        user.setUserId("yjhan");
//        user.setEmail("yjhan@meshkorea.net");
    }

}
