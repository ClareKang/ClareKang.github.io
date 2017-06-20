package net.meshkorea.mcp.api.service.common;

import net.meshkorea.mcp.api.domain.entity.common.Codes;
import net.meshkorea.mcp.api.domain.model.auth.CodeListResponse;
import net.meshkorea.mcp.api.domain.model.common.CodesDto;
import net.meshkorea.mcp.api.domain.model.common.CodesEnum;
import net.meshkorea.mcp.api.domain.repository.CodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 14..
 */
@Service
public class McpCommonService {

    @Autowired
    CodesRepository codesRepository;

    @Transactional
    public CodeListResponse getUserTypes() {
        return new CodeListResponse(getChildren(CodesEnum.USER_TYPE.name()));
    }

    @Transactional
    public CodeListResponse getUserSearchTypes() {
        return new CodeListResponse(getChildren(CodesEnum.USER_SEARCH_TYPE.name()));
    }

    @Transactional
    public CodeListResponse getGroupTypes() {
        return new CodeListResponse(getChildren(CodesEnum.GROUP_TYPE.name()));
    }

    @Transactional
    public CodeListResponse getGroupSearchTypes() {
        return new CodeListResponse(getChildren(CodesEnum.GROUP_SEARCH_TYPE.name()));
    }

    // TODO: 성능 이슈 처리를 위해 수정해야된다. ex) cache
    private List<CodesDto> getChildren(String code) {
        if (code == null)
            return null;

        Codes parent = codesRepository.findOneByCode(code);
        List<CodesDto> codesDtos = CodesDto.toCodesDtos(parent.getChildren());

        if (codesDtos != null && !codesDtos.isEmpty()) {
            codesDtos.forEach(codesDto -> {
                codesDto.setChildren(traversal(codesDto));
            });
        }

        return codesDtos;
    }

    private List<CodesDto> traversal(CodesDto codesDto) {
        if (codesDto == null)
            return null;

        List<Codes> codes = codesRepository.findAllByParent(codesDto.getCodeNo());
        if (codes.isEmpty())
            return new ArrayList<>();
        else {
            List<CodesDto> children = CodesDto.toCodesDtos(codes);
            children.forEach(child -> {
                child.setChildren(traversal(child));
            });

            return children;
        }
    }
}
