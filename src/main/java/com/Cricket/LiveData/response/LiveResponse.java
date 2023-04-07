package com.Cricket.LiveData.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LiveResponse {

    @JsonProperty("meta")
    private CricketInfo cricketInfo;

    @JsonProperty("results")
    private List<CricketResults> cricketResults;


}
