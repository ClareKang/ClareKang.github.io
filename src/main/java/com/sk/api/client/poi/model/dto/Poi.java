package com.sk.api.client.poi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by reverof on 2017-05-04.
 */
@Getter
@Setter
public class Poi {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("telNo")
    public String telNo;

    @JsonProperty("frontLat")
    public String frontLat;

    @JsonProperty("frontLon")
    public String frontLon;

    @JsonProperty("noorLat")
    public String noorLat;

    @JsonProperty("noorLon")
    public String noorLon;

    @JsonProperty("upperAddrName")
    public String upperAddrName;

    @JsonProperty("middleAddrName")
    public String middleAddrName;

    @JsonProperty("lowerAddrName")
    public String lowerAddrName;

    @JsonProperty("detailAddrName")
    public String detailAddrName;

    @JsonProperty("firstNo")
    public String firstNo;

    @JsonProperty("secondNo")
    public String secondNo;

    @JsonProperty("roadName")
    public String roadName;

    @JsonProperty("firstBuildNo")
    public String firstBuildNo;

    @JsonProperty("secondBuildNo")
    public String secondBuildNo;

    @JsonProperty("radius")
    public String radius;

    @JsonProperty("bizName")
    public String bizName;

    @JsonProperty("upperBizName")
    public String upperBizName;

    @JsonProperty("middleBizName")
    public String middleBizName;

    @JsonProperty("lowerBizName")
    public String lowerBizName;

    @JsonProperty("detailBizName")
    public String detailBizName;

    @JsonProperty("rpFlag")
    public String rpFlag;

    @JsonProperty("parkFlag")
    public String parkFlag;

    @JsonProperty("detailInfoFlag")
    public String detailInfoFlag;

    @JsonProperty("desc")
    public String desc;

}
