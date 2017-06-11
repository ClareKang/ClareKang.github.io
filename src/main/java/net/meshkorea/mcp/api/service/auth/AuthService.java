package net.meshkorea.mcp.api.service.auth;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.model.auth.UserDto;
import net.meshkorea.mcp.api.domain.model.auth.UserListRequest;
import net.meshkorea.mcp.api.domain.repository.UserRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    public Page<User> getUsers(UserListRequest userListRequest, Pageable pageable) {
        Page<User> users = userRepository.search(userListRequest, pageable);
        users.map(user -> modelMapper.map(user, UserDto.class));
        return userRepository.search(userListRequest, pageable);
    }

    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }

    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

}
