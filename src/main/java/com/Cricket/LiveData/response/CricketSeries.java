package com.Cricket.LiveData.response;

import org.springframework.stereotype.Component;

@Component
public class CricketSeries {

    private String series_id;
    private String series_name;
    private String status;
    private  String season;
    private  String updated_at;


    public String getSeries_id() {
        return series_id;
    }

    public void setSeries_id(String series_id) {
        this.series_id = series_id;
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "CricketSeries{" +
                "series_id='" + series_id + '\'' +
                ", series_name='" + series_name + '\'' +
                ", status='" + status + '\'' +
                ", season='" + season + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
