package com.tuncerergin.rickandmorty.service;

import com.tuncerergin.rickandmorty.entity.character.Characters;
import com.tuncerergin.rickandmorty.entity.character.Result;
import com.tuncerergin.rickandmorty.entity.episode.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceImpl implements RestService {

    private final RestTemplate restTemplate;
    private final String url;

    @Autowired
    public RestServiceImpl(
            RestTemplate theRestTemplate,
            @Value("https://rickandmortyapi.com/api/") String theUrl) {
        restTemplate = theRestTemplate;
        url = theUrl;
    }

    @Override
    public Characters getCharacters(long page, String shortby) {
        ResponseEntity<Characters> responseEntity =
                restTemplate.exchange(url + "/character/" + ((page == 0) ? "" : "?page=" + page),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<Characters>() {
                        });
        return responseEntity.getBody();
    }

    @Override
    public Result getCharacter(long id) {
        return restTemplate.getForObject(url + "/character/" + id,
                Result.class);
    }

    @Override
    public com.tuncerergin.rickandmorty.entity.episode.Result getEpisode(long id) {
        // make REST call
        ResponseEntity<com.tuncerergin.rickandmorty.entity.episode.Result> responseEntity =
                restTemplate.exchange(url + "/episode/" + id,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<com.tuncerergin.rickandmorty.entity.episode.Result>() {
                        });
        return responseEntity.getBody();
    }

    @Override
    public Episode getEpisode(long page, String shortby) {
        ResponseEntity<Episode> responseEntity =
                restTemplate.exchange(url + "/episode/" + ((page == 0) ? "" : "?page=" + page),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<Episode>() {
                        });
        return responseEntity.getBody();
    }


}
