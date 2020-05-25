package com.tuncerergin.rickandmorty.service;

import com.tuncerergin.rickandmorty.entity.character.Characters;
import com.tuncerergin.rickandmorty.entity.episode.Result;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ThreadServiceImpl implements ThreadService {

    final
    RestTemplate restTemplate;

    public ThreadServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Async
    public CompletableFuture<Characters> findUser(long character) {
        String url = "https://rickandmortyapi.com/api/character/" + character;
        Characters results = restTemplate.getForObject(url, Characters.class);
        // Artificial delay of 1s for demonstration purposes
        //Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

    @Override
    @Async
    public CompletableFuture<Result> findEpisode(long episode) {
        String url = "https://rickandmortyapi.com/api/episode/" + episode;
        Result results =
                restTemplate.getForObject(url, Result.class);
        // Artificial delay of 1s for demonstration purposes
        // Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }
}
