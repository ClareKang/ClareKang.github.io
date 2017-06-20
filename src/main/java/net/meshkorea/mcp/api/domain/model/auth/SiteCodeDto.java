package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.auth.SiteCode;

/**
 * Created by reverof on 2017. 6. 11..
 */
@Getter
@Setter
public class SiteCodeDto {

    private Long siteCodeNo;

    private String siteCode;

    private String siteName;

    public static SiteCodeDto toSiteCodeDto(SiteCode siteCode) {
        if (siteCode == null)
            return null;

        SiteCodeDto siteCodeDto = new SiteCodeDto();

        siteCodeDto.setSiteCodeNo(siteCode.getSiteCodeNo());
        siteCodeDto.setSiteCode(siteCode.getSiteCode());
        siteCodeDto.setSiteName(siteCode.getSiteName());

        return siteCodeDto;
    }

    public static SiteCode toSiteCode(SiteCodeDto siteCodeDto) {
        if (siteCodeDto == null)
            return null;

        SiteCode siteCode = new SiteCode();
        siteCode.setSiteCodeNo(siteCodeDto.getSiteCodeNo());
        siteCode.setSiteCode(siteCodeDto.getSiteCode());
        siteCode.setSiteName(siteCodeDto.getSiteName());

        return siteCode;
    }

}
