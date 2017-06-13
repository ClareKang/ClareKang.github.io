package net.meshkorea.mcp.api.service.auth;

import net.meshkorea.mcp.api.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017-06-08.
 */
@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

}
