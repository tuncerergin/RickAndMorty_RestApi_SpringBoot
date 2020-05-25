
package com.tuncerergin.rickandmorty.entity.character;

import java.util.List;

public class Characters {


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
        return "Characters{" +
                "info=" + info +
                ", results=" + results +
                '}';
    }
}
