package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.auth.Authority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 11..
 */
@Getter
@Setter
public class AuthorityDto {

    private Long authorityNo;

    private SiteCodeDto siteCodeDto;

    private String authorityName;

    private String authorityCode;

    private String hasPrivacy;

    private Integer displayOrder;

    private String viewName;

    private String viewUri;

    private List<UserAuthorityDto> userAuthorityDtos = new ArrayList<>();

    private List<GroupAuthorityDto> groupAuthorityDtos = new ArrayList<>();

    private List<ResourceDto> resourceDtos = new ArrayList<>();

    public static AuthorityDto toAuthorityDto(Authority authority) {
        if (authority == null)
            return null;

        AuthorityDto authorityDto = new AuthorityDto();

        authorityDto.setAuthorityNo(authority.getAuthorityNo());
        authorityDto.setSiteCodeDto(SiteCodeDto.toSiteCodeDto(authority.getSiteCode()));
        authorityDto.setAuthorityName(authority.getAuthorityName());
        authorityDto.setAuthorityCode(authority.getAuthorityCode());
        authorityDto.setHasPrivacy(authority.getHasPrivacy());
        authorityDto.setDisplayOrder(authority.getDisplayOrder());
        authorityDto.setViewName(authority.getViewName());
        authorityDto.setViewUri(authority.getViewUri());

        return authorityDto;
    }

    public static List<AuthorityDto> toAuthorityDtos(List<Authority> authorities) {
        if (authorities == null)
            return null;

        List<AuthorityDto> authorityDtos = new ArrayList<>();

        authorities.forEach(authority -> {
            authorityDtos.add(AuthorityDto.toAuthorityDto(authority));
        });

        return authorityDtos;
    }

    public static Authority toAuthority(AuthorityDto authorityDto) {
        if (authorityDto == null)
            return null;

        Authority authority = new Authority();

        authority.setAuthorityNo(authorityDto.getAuthorityNo());
        authority.setSiteCode(SiteCodeDto.toSiteCode(authorityDto.getSiteCodeDto()));
        authority.setAuthorityName(authorityDto.getAuthorityName());
        authority.setAuthorityCode(authorityDto.getAuthorityCode());
        authority.setHasPrivacy(authorityDto.getHasPrivacy());
        authority.setDisplayOrder(authorityDto.getDisplayOrder());
        authority.setViewName(authorityDto.getViewName());
        authority.setViewUri(authorityDto.getViewUri());

        return authority;
    }

    public static List<Authority> toAuthorities(List<AuthorityDto> authorityDtos) {
        if (authorityDtos == null)
            return null;

        List<Authority> authorities = new ArrayList<>();

        authorityDtos.forEach(authorityDto -> {
            authorities.add(AuthorityDto.toAuthority(authorityDto));
        });

        return authorities;
    }

}
