package com.example.my123.Games;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Game {

    @SerializedName("begin_at")
    @Expose
    private Object beginAt;
    @SerializedName("draw")
    @Expose
    private Boolean draw;
    @SerializedName("end_at")
    @Expose
    private Object endAt;
    @SerializedName("forfeit")
    @Expose
    private Boolean forfeit;
    @SerializedName("games")
    @Expose
    private List<Game> games ;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("league")
    @Expose
    private League league;
    @SerializedName("league_id")
    @Expose
    private Integer leagueId;
    @SerializedName("live")
    @Expose
    private Live live;
    @SerializedName("match_type")
    @Expose
    private String matchType;
    @SerializedName("modified_at")
    @Expose
    private String modifiedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number_of_games")
    @Expose
    private Integer numberOfGames;
    @SerializedName("opponents")
    @Expose
    private List<Opponent> opponents = null;
    @SerializedName("results")
    @Expose
    private List<Result> results ;
    @SerializedName("serie")
    @Expose
    private Serie serie;
    @SerializedName("serie_id")
    @Expose
    private Integer serieId;
    @SerializedName("slug")
    @Expose
    private Object slug;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tournament")
    @Expose
    private Tournament tournament;
    @SerializedName("tournament_id")
    @Expose
    private Integer tournamentId;
    @SerializedName("videogame")
    @Expose
    private Videogame videogame;
    @SerializedName("videogame_version")
    @Expose
    private Object videogameVersion;
    @SerializedName("winner")
    @Expose
    private Object winner;
    @SerializedName("winner_id")
    @Expose
    private Object winnerId;

    public Object getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(Object beginAt) {
        this.beginAt = beginAt;
    }

    public Boolean getDraw() {
        return draw;
    }

    public void setDraw(Boolean draw) {
        this.draw = draw;
    }

    public Object getEndAt() {
        return endAt;
    }

    public void setEndAt(Object endAt) {
        this.endAt = endAt;
    }

    public Boolean getForfeit() {
        return forfeit;
    }

    public void setForfeit(Boolean forfeit) {
        this.forfeit = forfeit;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Live getLive() {
        return live;
    }

    public void setLive(Live live) {
        this.live = live;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
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

    public Integer getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(Integer numberOfGames) {
        this.numberOfGames = numberOfGames;
    }



    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

    public Object getSlug() {
        return slug;
    }

    public void setSlug(Object slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Videogame getVideogame() {
        return videogame;
    }

    public void setVideogame(Videogame videogame) {
        this.videogame = videogame;
    }

    public Object getVideogameVersion() {
        return videogameVersion;
    }

    public void setVideogameVersion(Object videogameVersion) {
        this.videogameVersion = videogameVersion;
    }

    public Object getWinner() {
        return winner;
    }

    public void setWinner(Object winner) {
        this.winner = winner;
    }

    public Object getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Object winnerId) {
        this.winnerId = winnerId;
    }

    public List<Opponent> getOpponents() {
        return opponents;
    }

    public void setOpponents(List<Opponent> opponents) {
        this.opponents = opponents;
    }
}

