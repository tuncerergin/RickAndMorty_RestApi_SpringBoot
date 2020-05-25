
package com.tuncerergin.rickandmorty.entity.episode;

import java.util.List;

public class Episode {


    private Info info;

    private List<Result> results = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "info=" + info +
                ", results=" + results +
                '}';
    }
}
