package net.meshkorea.mcp.api.entity.order;

import net.meshkorea.mcp.api.entity.common.LatLng;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Created by sangki on 2016. 7. 5..
 */
@Embeddable
public class OrderAddress {// extends Address {

    @Column( name = "baseAddress" )
    private String baseAddress;

    @Column( name = "citydo" )
    private String cityDo;

    @Column( name = "gugun" )
    private String guGun;

    @Column( name = "eupmyundong" )
    private String eupMyunDong;

    @Column( name = "ri" )
    private String ri;

    @Column( name = "zipcode" )
    private String zipcode;

    @Embedded
    private LatLng latLng;

    @Column( name = "roadaddress" )
    private String roadAddress;

    @Column( name = "bunjiaddress" )
    private String bunjiAddress;

    @Column( name = "bunjino" )
    private String bunjiNo;

    public void setBaseAddress(String baseAddress) { this.baseAddress = baseAddress; }

    public String getBaseAddress() { return baseAddress; }

    public String getCityDo() {
        return cityDo;
    }

    public void setCityDo(String cityDo) {
        this.cityDo = cityDo;
    }

    public String getGuGun() {
        return guGun;
    }

    public void setGuGun(String guGun) {
        this.guGun = guGun;
    }

    public String getEupMyunDong() {
        return eupMyunDong;
    }

    public void setEupMyunDong(String eupMyunDong) {
        this.eupMyunDong = eupMyunDong;
    }

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public String getBunjiAddress() {
        return bunjiAddress;
    }

    public void setBunjiAddress(String bunjiAddress) {
        this.bunjiAddress = bunjiAddress;
    }

    public String getBunjiNo() {
        return bunjiNo;
    }

    public void setBunjiNo(String bunjiNo) {
        this.bunjiNo = bunjiNo;
    }
}
