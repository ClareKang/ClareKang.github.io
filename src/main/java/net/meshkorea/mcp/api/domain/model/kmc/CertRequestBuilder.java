package net.meshkorea.mcp.api.domain.model.kmc;

public class CertRequestBuilder {
    private String cpId = "";
    private String urlCode = "";
    private String certNum = "";
    private String date = "";
    private String certMethod = "";
    private String birthday = "";
    private String gender = "";
    private String name = "";
    private String phoneNo = "";
    private String phoneCorp = "";
    private String nation = "";
    private String plusInfo = "";
    private String extendVar = "";

    public CertRequestBuilder setCpId(String cpId) {
        this.cpId = cpId;
        return this;
    }

    public CertRequestBuilder setUrlCode(String urlCode) {
        this.urlCode = urlCode;
        return this;
    }

    public CertRequestBuilder setCertNum(String certNum) {
        this.certNum = certNum;
        return this;
    }

    public CertRequestBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public CertRequestBuilder setCertMethod(String certMethod) {
        this.certMethod = certMethod;
        return this;
    }

    public CertRequestBuilder setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public CertRequestBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CertRequestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CertRequestBuilder setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public CertRequestBuilder setPhoneCorp(String phoneCorp) {
        this.phoneCorp = phoneCorp;
        return this;
    }

    public CertRequestBuilder setNation(String nation) {
        this.nation = nation;
        return this;
    }

    public CertRequestBuilder setPlusInfo(String plusInfo) {
        this.plusInfo = plusInfo;
        return this;
    }

    public CertRequestBuilder setExtendVar(String extendVar) {
        this.extendVar = extendVar;
        return this;
    }

    public CertRequest createCertRequest() {
        return new CertRequest(cpId, urlCode, certNum, date, certMethod, birthday, gender, name, phoneNo, phoneCorp, nation, plusInfo, extendVar);
    }
}