package net.meshkorea.mcp.api.codes;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by reverof on 2017. 4. 24..
 */
public enum BusinessClientUploadFileType {

    // 사업자 등록증 사본
    ENTERPRISE_REGISTRATION_COPY("enterprise_registration_copy"),
    // 통장 사본
    BANK_ACCOUNT_COPY("bank_account_copy"),
    // 대표자 신분증 사본
    CEO_ID_CARD_COPY("ceo_id_card_copy");

    private String uploadFileType;

    private BusinessClientUploadFileType() {

    }

    private BusinessClientUploadFileType(String uploadFileType) {
        this.uploadFileType = uploadFileType;
    }

    public String getUploadFileType() {
        return uploadFileType;
    }

    public Boolean isEquals(String value) {
        if (StringUtils.equals(uploadFileType, value)) {
            return true;
        }
        return false;
    }

}
