package com.sk.api.client.poi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by reverof on 2017-05-04.
 */
@Getter
@Setter
public class SearchPoiInfo {

    @JsonProperty("totalCount")
    public String totalCount;

    @JsonProperty("count")
    public String count;

    @JsonProperty("page")
    public String page;

    @JsonProperty("pois")
    public Pois pois;

}
