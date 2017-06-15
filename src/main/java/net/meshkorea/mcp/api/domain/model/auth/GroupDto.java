package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.auth.Group;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 10..
 */
@Getter
@Setter
public class GroupDto {

    private Long groupNo;

    private String groupName;

    private String isActive;

    private String hasPrivacy;

    private UserDto creator;

    private Date createDt;

    private UserDto updater;

    private Date updateDt;

    private String description;

    private List<AuthorityDto> authorityDtos = new ArrayList<>();

    public static GroupDto toGroupDto(Group group) {
        if (group == null)
            return null;

        GroupDto groupDto = new GroupDto();
        groupDto.setGroupNo(group.getGroupNo());
        groupDto.setGroupName(group.getGroupName());
        groupDto.setIsActive(group.getIsActive());
        groupDto.setHasPrivacy(group.getHasPrivacy());
        groupDto.setCreator(UserDto.toUserDto(group.getCreator()));
        groupDto.setCreateDt(group.getCreateDt());
        groupDto.setUpdater(UserDto.toUserDto(group.getUpdater()));
        groupDto.setUpdateDt(group.getUpdateDt());
        groupDto.setDescription(group.getDescription());

        return groupDto;
    }

    public static List<GroupDto> toGroupDtos(List<Group> groups) {
        if (groups == null)
            return null;

        List<GroupDto> groupDtos = new ArrayList<>();
        groups.forEach(group -> {
            groupDtos.add(GroupDto.toGroupDto(group));
        });

        return groupDtos;
    }

    public static Group toGroup(GroupDto groupDto) {
        if (groupDto == null)
            return null;

        Group group = new Group();
        group.setGroupNo(groupDto.getGroupNo());
        group.setGroupName(groupDto.getGroupName());
        group.setIsActive(groupDto.getIsActive());
        group.setHasPrivacy(groupDto.getHasPrivacy());
        group.setCreator(UserDto.toUser(groupDto.getCreator()));
        group.setCreateDt(groupDto.getCreateDt());
        group.setUpdater(UserDto.toUser(groupDto.getUpdater()));
        group.setUpdateDt(groupDto.getUpdateDt());
        group.setDescription(groupDto.getDescription());

        return group;
    }

    public static List<Group> toGroups(List<GroupDto> groupDtos) {
        if (groupDtos == null)
            return null;

        List<Group> groups = new ArrayList<>();
        groupDtos.forEach(groupDto -> {
            groups.add(GroupDto.toGroup(groupDto));
        });

        return groups;
    }
}
