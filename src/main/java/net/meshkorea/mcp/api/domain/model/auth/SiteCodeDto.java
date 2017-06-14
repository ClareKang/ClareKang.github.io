package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.auth.SiteCode;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 11..
 */
@Getter
@Setter
public class SiteCodeDto {

    private Long siteCodeNo;

    private String siteCode;

    private String siteName;

    private List<AuthorityDto> authorityDtos;

    public static SiteCodeDto toSiteCodeDto(SiteCode siteCode) {
        if (siteCode == null)
            return null;

        SiteCodeDto siteCodeDto = new SiteCodeDto();

        siteCodeDto.setSiteCodeNo(siteCode.getSiteCodeNo());
        siteCodeDto.setSiteCode(siteCode.getSiteCode());
        siteCodeDto.setSiteName(siteCode.getSiteName());
        siteCodeDto.setAuthorityDtos(AuthorityDto.toAuthorityDtos(siteCode.getAuthorities()));

        return siteCodeDto;
    }

    public static SiteCode toSiteCode(SiteCodeDto siteCodeDto) {
        if (siteCodeDto == null)
            return null;

        SiteCode siteCode = new SiteCode();
        siteCode.setSiteCodeNo(siteCodeDto.getSiteCodeNo());
        siteCode.setSiteCode(siteCodeDto.getSiteCode());
        siteCode.setSiteName(siteCodeDto.getSiteName());
        siteCode.setAuthorities(AuthorityDto.toAuthorities(siteCodeDto.getAuthorityDtos()));

        return siteCode;
    }

}
