package net.meshkorea.mcp.api.service.auth;

import net.meshkorea.mcp.api.domain.model.auth.AuthorityDto;
import net.meshkorea.mcp.api.domain.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by reverof on 2017-06-08.
 */
@Service
public class AuthoritiesService {

    @Autowired
    AuthorityRepository authorityRepository;

    @Transactional
    public List<AuthorityDto> getAllAuthorities() {
        return AuthorityDto.toAuthorityDtos(authorityRepository.findAll());
    }
}
