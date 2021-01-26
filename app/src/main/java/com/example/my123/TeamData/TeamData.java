package com.example.my123.TeamData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamData {
    @SerializedName("acronym")
    @Expose
    private Object acronym;
    @SerializedName("current_videogame")
    @Expose
    private CurrentVideogame currentVideogame;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("players")
    @Expose
    private List<Player> players = null;
    @SerializedName("slug")
    @Expose
    private String slug;

    public Object getAcronym() {
        return acronym;
    }

    public void setAcronym(Object acronym) {
        this.acronym = acronym;
    }

    public CurrentVideogame getCurrentVideogame() {
        return currentVideogame;
    }

    public void setCurrentVideogame(CurrentVideogame currentVideogame) {
        this.currentVideogame = currentVideogame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
