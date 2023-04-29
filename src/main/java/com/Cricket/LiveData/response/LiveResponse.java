package com.Cricket.LiveData.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LiveResponse {

    @JsonProperty("meta")
    private CricketInfo cricketInfo;

    @JsonProperty("results")
    private List<CricketResults> cricketResults;


    public CricketInfo getCricketInfo() {
        return cricketInfo;
    }

    public void setCricketInfo(CricketInfo cricketInfo) {
        this.cricketInfo = cricketInfo;
    }

    public List<CricketResults> getCricketResults() {
        return cricketResults;
    }

    public void setCricketResults(List<CricketResults> cricketResults) {
        this.cricketResults = cricketResults;
    }
}
