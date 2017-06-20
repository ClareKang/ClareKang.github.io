package net.meshkorea.mcp.api.service.auth;

import net.meshkorea.mcp.api.domain.entity.auth.Authority;
import net.meshkorea.mcp.api.domain.entity.auth.Group;
import net.meshkorea.mcp.api.domain.model.auth.*;
import net.meshkorea.mcp.api.domain.model.common.PageableRequestMapper;
import net.meshkorea.mcp.api.domain.repository.AuthorityRepository;
import net.meshkorea.mcp.api.domain.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by reverof on 2017. 6. 18..
 */
@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

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

    public GroupResponse getGroup(Long groupId) {
        Group group = groupRepository.findOne(groupId);

        return new GroupResponse(GroupDto.toGroupDto(group));
    }

    public AuthorityListResponse getAuthoritiesByGroup(Long groupId) {
        List<Authority> authorities = authorityRepository.getAllAuthoritiesWithGrantedGroups(groupId);

        if (authorities.isEmpty()) {
            return new AuthorityListResponse(
                0,
                1000,
                1,
                0L,
                null
            );
        }

        return new AuthorityListResponse(
            0,
            1000,
            1,
            Long.valueOf(authorities.size()),
            authorities.stream().map(authority -> AuthorityDto.toAuthorityDto(authority)).collect(Collectors.toList())
        );
    }

}
