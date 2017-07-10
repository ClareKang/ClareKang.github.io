package net.meshkorea.mcp.api.service.auth;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.model.auth.UserDto;
import net.meshkorea.mcp.api.domain.model.auth.UserListRequest;
import net.meshkorea.mcp.api.domain.model.auth.UserListResponse;
import net.meshkorea.mcp.api.domain.model.auth.UserResponse;
import net.meshkorea.mcp.api.domain.model.common.PageableRequestMapper;
import net.meshkorea.mcp.api.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by reverof on 2017-06-13.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserListResponse getUsers(UserListRequest userListRequest) {
        Pageable pageable = PageableRequestMapper.getPageRequest(
            userListRequest,
            new Sort(Sort.Direction.DESC, "createDt")
        );

        Page<User> users = userRepository.search(userListRequest, pageable);

        return new UserListResponse(
            users.getNumber(),
            users.getSize(),
            users.getTotalPages(),
            users.getTotalElements(),
            users.getContent().stream().map(user -> UserDto.toUserDto(user)).collect(Collectors.toList())
        );
    }

    public UserResponse getUser(Long userId) {
        User user = userRepository.findOne(userId);
        return new UserResponse(UserDto.toUserDto(user));
    }

    public UserResponse addUser(UserDto userDto) {
        User user = userRepository.save(UserDto.toUser(userDto));
        return new UserResponse(UserDto.toUserDto(user));
    }

    public UserResponse updateUser(UserDto userDto) {
        User user = userRepository.save(UserDto.toUser(userDto));
        return new UserResponse(UserDto.toUserDto(user));
    }

}
