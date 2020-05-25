package com.tuncerergin.rickandmorty.service;

import com.tuncerergin.rickandmorty.entity.character.Characters;
import com.tuncerergin.rickandmorty.entity.episode.Result;

import java.util.concurrent.CompletableFuture;

public interface ThreadService {
    CompletableFuture<Characters> findUser(long user);

    CompletableFuture<Result> findEpisode(long episode);
}
