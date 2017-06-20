package net.meshkorea.mcp.api.service.auth;

import net.meshkorea.mcp.api.domain.entity.auth.Group;
import net.meshkorea.mcp.api.domain.model.auth.GroupAuthorityDto;
import net.meshkorea.mcp.api.domain.model.auth.GroupDto;
import net.meshkorea.mcp.api.domain.model.auth.GroupListRequest;
import net.meshkorea.mcp.api.domain.model.auth.GroupListResponse;
import net.meshkorea.mcp.api.domain.model.common.PageableRequestMapper;
import net.meshkorea.mcp.api.domain.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by reverof on 2017. 6. 18..
 */
@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public GroupListResponse getGroups(GroupListRequest groupListRequest) {
        Pageable pageable = PageableRequestMapper.getPageRequest(
            groupListRequest,
            new Sort(Sort.Direction.DESC, "createDt")
        );

        Page<Group> groups = groupRepository.search(groupListRequest, pageable);

        return new GroupListResponse(
            groups.getNumber(),
            groups.getSize(),
            groups.getTotalPages(),
            groups.getTotalElements(),
            groups.getContent().stream().map(group -> GroupDto.toGroupDto(group)).collect(Collectors.toList())
        );
    }

    public GroupDto getGroup(Long groupId) {
        Group group = groupRepository.getGroupWithAuthorities(groupId);
        GroupDto groupDto = GroupDto.toGroupDto(group);
        groupDto.setGroupAuthorityDtos(GroupAuthorityDto.toGroupAuthorityDtos(group.getGroupAuthorities()));

        return groupDto;
    }
}
