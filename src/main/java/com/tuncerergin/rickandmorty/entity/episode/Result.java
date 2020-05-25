
package com.tuncerergin.rickandmorty.entity.episode;

import java.util.List;

public class Result {

    private int id;
    private String name;
    private String airDate;
    private String episode;
    private List<String> characters = null;
    private String url;
    private String created;
    private String season;
    private String seasonEpisode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSeasonEpisode() {
        return seasonEpisode;
    }

    public void setSeasonEpisode(String seasonEpisode) {
        this.seasonEpisode = seasonEpisode;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", airDate='" + airDate + '\'' +
                ", episode='" + episode + '\'' +
                ", characters=" + characters +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                ", season='" + season + '\'' +
                ", seasonEpisode='" + seasonEpisode + '\'' +
                '}';
    }
}
