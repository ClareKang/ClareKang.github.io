package net.meshkorea.mcp.api.service.common;

import net.meshkorea.mcp.api.domain.entity.common.Codes;
import net.meshkorea.mcp.api.domain.model.auth.UserTypeListResponse;
import net.meshkorea.mcp.api.domain.model.common.CodesDto;
import net.meshkorea.mcp.api.domain.model.common.CodesEnum;
import net.meshkorea.mcp.api.domain.repository.AuthCodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 14..
 */
@Service
public class McpCommonService {
    @Autowired
    AuthCodesRepository authCodesRepository;

    private List<CodesDto> getChildren(Long parent) {
        return CodesDto.toCodesDtos(authCodesRepository.findAllByParent(parent));
    }

    private void traversal() {

    }

    // TODO: 순회하면서 하위 트리를 가져오도록 만들어야됨
    @Transactional
    public UserTypeListResponse getUserTypes() {
        Codes parent = authCodesRepository.findOneByCode(CodesEnum.USER_TYPE.name());

        return new UserTypeListResponse(
            CodesDto.toCodesDtos(parent.getChildren())
        );
    }
}
