package com.tuncerergin.rickandmorty.service;

import com.tuncerergin.rickandmorty.entity.character.Characters;
import com.tuncerergin.rickandmorty.entity.character.Result;
import com.tuncerergin.rickandmorty.entity.episode.Episode;

public interface RestService {
    Characters getCharacters(long page, String shortby);

    Result getCharacter(long id);

    com.tuncerergin.rickandmorty.entity.episode.Result getEpisode(long id);

    Episode getEpisode(long page, String shortby);

}
