package com.Cricket.LiveData.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CricketResults {

    private String type;

    @JsonProperty("series")
    private List<CricketSeries> cricketSeries;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CricketSeries> getCricketSeries() {
        return cricketSeries;
    }

    public void setCricketSeries(List<CricketSeries> cricketSeries) {
        this.cricketSeries = cricketSeries;
    }
}
