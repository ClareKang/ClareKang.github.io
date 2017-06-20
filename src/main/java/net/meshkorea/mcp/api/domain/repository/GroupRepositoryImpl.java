package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.jpa.JPQLQuery;
import net.meshkorea.mcp.api.domain.entity.auth.Group;
import net.meshkorea.mcp.api.domain.entity.auth.QAuthority;
import net.meshkorea.mcp.api.domain.entity.auth.QGroup;
import net.meshkorea.mcp.api.domain.entity.auth.QGroupAuthority;
import net.meshkorea.mcp.api.domain.model.auth.GroupListRequest;
import net.meshkorea.mcp.api.domain.model.auth.GroupListTypeEnum;
import net.meshkorea.mcp.api.domain.model.auth.PrivacyEnum;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 18..
 */
public class GroupRepositoryImpl extends AuthRepositoryQueryDslSupport implements GroupRepositoryCustom {

    public GroupRepositoryImpl() {
        super(Group.class);
    }

    public Page<Group> search(GroupListRequest groupListRequest, Pageable pageable) {
        QGroup group = QGroup.group;

        JPQLQuery<Group> query = from(group);

        if (groupListRequest != null) {
            if (groupListRequest.getSearchType() != null) {
                if (GroupListTypeEnum.GROUP_NAME.name().equals(groupListRequest.getSearchType())) {
                    query.where(group.groupName.like("%" + groupListRequest.getSearchText() + "%"));
                } else if (GroupListTypeEnum.GROUP_CODE.name().equals(groupListRequest.getSearchType())) {
                    if (NumberUtils.isDigits(groupListRequest.getSearchText())) {
                        query.where(group.groupNo.eq(Long.valueOf(groupListRequest.getSearchText())));
                    }
                }
            }
            if (groupListRequest.getHasPrivacy() != null) {
                if (groupListRequest.hasPrivacy()) {
                    query.where(group.hasPrivacy.eq(PrivacyEnum.Y.name()));
                } else if (!groupListRequest.hasPrivacy()) {
                    query.where(group.hasPrivacy.eq(PrivacyEnum.N.name()));
                }
            }
        }

        List<Group> groups = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();

        return new PageImpl<>(groups, pageable, totalCount);
    }

}
