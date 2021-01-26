package com.example.my123.Games;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tournament {
    @SerializedName("begin_at")
    @Expose
    private Object beginAt;
    @SerializedName("end_at")
    @Expose
    private Object endAt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("league_id")
    @Expose
    private Integer leagueId;
    @SerializedName("modified_at")
    @Expose
    private String modifiedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("serie_id")
    @Expose
    private Integer serieId;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("winner_id")
    @Expose
    private Object winnerId;
    @SerializedName("winner_type")
    @Expose
    private Object winnerType;

    public Object getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(Object beginAt) {
        this.beginAt = beginAt;
    }

    public Object getEndAt() {
        return endAt;
    }

    public void setEndAt(Object endAt) {
        this.endAt = endAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Object getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Object winnerId) {
        this.winnerId = winnerId;
    }

    public Object getWinnerType() {
        return winnerType;
    }

    public void setWinnerType(Object winnerType) {
        this.winnerType = winnerType;
    }
}
