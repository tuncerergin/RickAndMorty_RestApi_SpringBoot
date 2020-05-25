package com.tuncerergin.rickandmorty.controller;

import com.tuncerergin.rickandmorty.entity.character.Characters;
import com.tuncerergin.rickandmorty.entity.character.Result;
import com.tuncerergin.rickandmorty.service.RestService;
import com.tuncerergin.rickandmorty.service.ThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/api")
public class CharacterController {

    private final RestService restService;
    public final ThreadService threadService;

    public CharacterController(RestService restService, ThreadService threadService) {
        this.restService = restService;
        this.threadService = threadService;
    }


    @GetMapping("/character")
    public String listCharacter(@RequestParam(value = "id", required = false, defaultValue = "0") long id,
                                @RequestParam(value = "page", required = false, defaultValue = "0") long page,
                                @RequestParam(value = "sortBy", required = false, defaultValue = "") String sortBy,
                                Model theModel) throws InterruptedException, ExecutionException {

        if (id != 0) {
            Result theCharacter = restService.getCharacter(id);
            List<com.tuncerergin.rickandmorty.entity.episode.Result> episodes = new ArrayList<>();
            long start = System.currentTimeMillis();
            for (String episodeUrl : theCharacter.getEpisode()) {

                // Kick of multiple, asynchronous lookups
                CompletableFuture<com.tuncerergin.rickandmorty.entity.episode.Result> thread =
                        threadService.findEpisode(Long.parseLong(episodeUrl.substring(episodeUrl.lastIndexOf("/") + 1) + ""));
                episodes.add(thread.get());
                // Wait until they are all done
                // CompletableFuture.allOf(page1,page2,page3).join();


            }
            System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));

            theModel.addAttribute("character", theCharacter);
            theModel.addAttribute("episodes", episodes);
            return "character";
        } else {
            Characters theCharacter = restService.getCharacters(page, sortBy);
            if (sortBy.equals("name")) {
                Comparator<Result> compareById = (Result r1, Result r2) -> r1.getName().compareTo(r2.getName());
                theCharacter.getResults().sort(compareById);
            } else if (sortBy.equals("episode")) {
                Comparator<Result> compareById = (Result r1, Result r2) -> (String.valueOf(r1.getEpisode().size())).compareTo(String.valueOf(r2.getEpisode().size()));
                theCharacter.getResults().sort(compareById);
            }
            int beginIndex = (int) Math.max(1, page - 5);
            int endIndex = (int) Math.min(page + 6, theCharacter.getInfo().getPages() + 1);
            ArrayList<Integer> pagination = new ArrayList<Integer>();
            for (int i = beginIndex; i < endIndex; i++)
                pagination.add(i);
            theModel.addAttribute("pagination", pagination);
            theModel.addAttribute("character", theCharacter);
            return "list-character";
        }
    }
}
