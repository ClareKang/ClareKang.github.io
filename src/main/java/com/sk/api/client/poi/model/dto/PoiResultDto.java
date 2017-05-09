package com.sk.api.client.poi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by reverof on 2017-05-10.
 */
@Getter
@Setter
public class PoiResultDto {

    @JsonProperty("searchPoiInfo")
    private SearchPoiInfo searchPoiInfo;

}
