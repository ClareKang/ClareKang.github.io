package net.meshkorea.mcp.api.service.auth;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.model.auth.SearchUserDto;
import net.meshkorea.mcp.api.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017-06-08.
 */
@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public Page<User> getUsers(SearchUserDto searchUserDto, Pageable pageable) {
        return userRepository.search(searchUserDto, pageable);
    }

    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }
}
