package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.auth.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 10..
 */
@Getter
@Setter
public class UserDto {

    private Long userNo;

    private String userId;

    private String userName;

    private String userType;

    private String phone;

    private String email;

    private String isActive;

    private String hasPrivacy;

    private UserDto creator;

    private LocalDateTime createDt;

    private UserDto updater;

    private LocalDateTime updateDt;

    private String description;

    private String memo;

    private List<GroupDto> groupDtos = new ArrayList<>();

    private List<AuthorityDto> authorityDtos = new ArrayList<>();

    public static UserDto toUserDto(User user) {
        if (user == null)
            return null;

        UserDto userDto = new UserDto();
        userDto.setUserNo(user.getUserNo());
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setUserType(user.getUserType());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        userDto.setIsActive(user.getIsActive());
        userDto.setHasPrivacy(user.getHasPrivacy());
        userDto.setCreator(UserDto.toUserDto(user.getCreator()));
        userDto.setCreateDt(user.getCreateDt());
        userDto.setUpdater(UserDto.toUserDto(user.getUpdater()));
        userDto.setUpdateDt(user.getUpdateDt());
        userDto.setDescription(user.getDescription());
        userDto.setMemo(user.getMemo());

        return userDto;
    }

    public static List<UserDto> toUserDtos(List<User> users) {
        if (users == null)
            return null;

        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            userDtos.add(UserDto.toUserDto(user));
        });

        return userDtos;
    }

    public static User toUser(UserDto userDto) {
        if (userDto == null)
            return null;

        User user = new User();
        user.setUserNo(userDto.getUserNo());
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserType(userDto.getUserType());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setIsActive(userDto.getIsActive());
        user.setHasPrivacy(userDto.getHasPrivacy());
        user.setCreator(UserDto.toUser(userDto.getCreator()));
        user.setCreateDt(userDto.getCreateDt());
        user.setUpdater(UserDto.toUser(userDto.getUpdater()));
        user.setUpdateDt(userDto.getUpdateDt());
        user.setDescription(userDto.getDescription());
        user.setMemo(userDto.getMemo());

        return user;
    }

    public static List<User> toUsers(List<UserDto> userDtos) {
        if (userDtos == null)
            return null;

        List<User> users = new ArrayList<>();
        userDtos.forEach(userDto -> {
            users.add(UserDto.toUser(userDto));
        });

        return users;
    }

}
