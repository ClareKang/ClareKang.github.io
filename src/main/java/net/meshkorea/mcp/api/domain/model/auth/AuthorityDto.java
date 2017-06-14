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

    private String viewName;

    private String viewUri;

    private String resourceName;

    private String resourceUri;

    private List<UserDto> userDtos;

    private List<GroupDto> groupDtos;

    public void setSiteCodeDto(SiteCodeDto siteCodeDto) {
        this.siteCodeDto = siteCodeDto;
        if (this.siteCodeDto != null && this.siteCodeDto.getAuthorityDtos() != null && !this.siteCodeDto.getAuthorityDtos().contains(this)) {
            this.siteCodeDto.getAuthorityDtos().add(this);
        }
    }

    public static AuthorityDto toAuthorityDto(Authority authority) {
        if (authority == null)
            return null;

        AuthorityDto authorityDto = new AuthorityDto();

        authorityDto.setAuthorityNo(authority.getAuthorityNo());
        authorityDto.setSiteCodeDto(SiteCodeDto.toSiteCodeDto(authority.getSiteCode()));
        authorityDto.setAuthorityName(authority.getAuthorityName());
        authorityDto.setAuthorityCode(authority.getAuthorityCode());
        authorityDto.setHasPrivacy(authority.getHasPrivacy());
        authorityDto.setViewName(authority.getViewName());
        authorityDto.setViewUri(authority.getViewUri());
        authorityDto.setResourceName(authority.getResourceName());
        authorityDto.setResourceUri(authority.getResourceUri());

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
        authority.setViewName(authorityDto.getViewName());
        authority.setViewUri(authorityDto.getViewUri());
        authority.setResourceName(authorityDto.getResourceName());
        authority.setResourceUri(authorityDto.getResourceUri());

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
