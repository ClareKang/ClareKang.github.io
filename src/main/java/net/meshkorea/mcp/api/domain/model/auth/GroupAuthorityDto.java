package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.auth.GroupAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 17..
 */
@Getter
@Setter
public class GroupAuthorityDto extends AuthorityAttributeDto {

    private GroupDto groupDto;

    private AuthorityDto authorityDto;

    public static GroupAuthorityDto toGroupAuthorityDto(GroupAuthority groupAuthority) {
        if (groupAuthority == null)
            return null;

        GroupAuthorityDto groupAuthorityDto = new GroupAuthorityDto();
        groupAuthorityDto.setGroupDto(GroupDto.toGroupDto(groupAuthority.getGroup()));
        groupAuthorityDto.setAuthorityDto(AuthorityDto.toAuthorityDto(groupAuthority.getAuthority()));
        groupAuthorityDto.setReadable(groupAuthority.getReadable());
        groupAuthorityDto.setWritable(groupAuthority.getWritable());
        groupAuthorityDto.setEditable(groupAuthority.getEditable());
        groupAuthorityDto.setDeletable(groupAuthority.getDeletable());
        groupAuthorityDto.setDownloadable(groupAuthority.getDownloadable());

        return groupAuthorityDto;
    }

    public static List<GroupAuthorityDto> toGroupAuthorityDtos(List<GroupAuthority> groupAuthorities) {
        if (groupAuthorities == null)
            return null;

        List<GroupAuthorityDto> groupAuthorityDtos = new ArrayList<>();
        groupAuthorities.forEach(groupAuthority -> {
            groupAuthorityDtos.add(GroupAuthorityDto.toGroupAuthorityDto(groupAuthority));
        });

        return groupAuthorityDtos;
    }

    public static GroupAuthority toGroupAuthority(GroupAuthorityDto groupAuthorityDto) {
        if (groupAuthorityDto == null)
            return null;

        GroupAuthority groupAuthority = new GroupAuthority();
        groupAuthority.setGroup(GroupDto.toGroup(groupAuthorityDto.getGroupDto()));
        groupAuthority.setAuthority(AuthorityDto.toAuthority(groupAuthorityDto.getAuthorityDto()));
        groupAuthority.setReadable(groupAuthorityDto.getReadable());
        groupAuthority.setWritable(groupAuthorityDto.getWritable());
        groupAuthority.setEditable(groupAuthorityDto.getEditable());
        groupAuthority.setDeletable(groupAuthorityDto.getDeletable());
        groupAuthority.setDownloadable(groupAuthorityDto.getDownloadable());

        return groupAuthority;
    }

    public static List<GroupAuthority> toGroupAuthorities(List<GroupAuthorityDto> groupAuthorityDtos) {
        if (groupAuthorityDtos == null)
            return null;

        List<GroupAuthority> groupAuthorities = new ArrayList<>();
        groupAuthorityDtos.forEach(groupAuthorityDto -> {
            groupAuthorities.add(GroupAuthorityDto.toGroupAuthority(groupAuthorityDto));
        });

        return groupAuthorities;
    }
}
