package net.meshkorea.mcp.api.entity.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jihunlee on 2016. 1. 17..
 */
@Embeddable
public class LatLng {

    @Column( name = "latitude" )
    private Double latitude;

    @Column( name = "longitude" )
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LatLng{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public String toLogstashString() {
        return "location{lat=" + latitude
                + " lng=" + longitude
                + "}";
    }
}
