package com.sk.api.client.poi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by reverof on 2017-05-10.
 */
@Getter
@Setter
public class Pois {

    @JsonProperty("poi")
    private List<Poi> poiList;

}
