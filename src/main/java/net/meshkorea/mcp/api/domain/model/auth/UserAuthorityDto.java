package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.auth.UserAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 16..
 */
@Getter
@Setter
public class UserAuthorityDto extends AuthorityAttributeDto {

    private UserDto userDto;

    private AuthorityDto authorityDto;

    public static UserAuthorityDto toUserAuthorityDto(UserAuthority userAuthority) {
        if (userAuthority == null)
            return null;

        UserAuthorityDto userAuthorityDto = new UserAuthorityDto();
        userAuthorityDto.setUserDto(UserDto.toUserDto(userAuthority.getUser()));
        userAuthorityDto.setAuthorityDto(AuthorityDto.toAuthorityDto(userAuthority.getAuthority()));
        userAuthorityDto.setReadable(userAuthority.getReadable());
        userAuthorityDto.setWritable(userAuthority.getWritable());
        userAuthorityDto.setEditable(userAuthority.getEditable());
        userAuthorityDto.setDeletable(userAuthority.getDeletable());
        userAuthorityDto.setDownloadable(userAuthority.getDownloadable());

        return userAuthorityDto;
    }

    public static List<UserAuthorityDto> toUserAuthorityDtos(List<UserAuthority> userAuthorities) {
        if (userAuthorities == null)
            return null;

        List<UserAuthorityDto> userAuthorityDtos = new ArrayList<>();
        userAuthorities.forEach(userAuthority -> {
            userAuthorityDtos.add(UserAuthorityDto.toUserAuthorityDto(userAuthority));
        });

        return userAuthorityDtos;
    }

    public static UserAuthority toUserAuthority(UserAuthorityDto userAuthorityDto) {
        if (userAuthorityDto == null)
            return null;

        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setUser(UserDto.toUser(userAuthorityDto.getUserDto()));
        userAuthority.setAuthority(AuthorityDto.toAuthority(userAuthorityDto.getAuthorityDto()));
        userAuthority.setReadable(userAuthorityDto.getReadable());
        userAuthority.setWritable(userAuthorityDto.getWritable());
        userAuthority.setEditable(userAuthorityDto.getEditable());
        userAuthority.setDeletable(userAuthorityDto.getDeletable());
        userAuthority.setDownloadable(userAuthorityDto.getDownloadable());

        return userAuthority;
    }

    public static List<UserAuthority> toUserAuthorities(List<UserAuthorityDto> userAuthorityDtos) {
        if (userAuthorityDtos == null)
            return null;

        List<UserAuthority> userAuthorities = new ArrayList<>();
        userAuthorityDtos.forEach(userAuthorityDto -> {
            userAuthorities.add(UserAuthorityDto.toUserAuthority(userAuthorityDto));
        });

        return userAuthorities;
    }
}
