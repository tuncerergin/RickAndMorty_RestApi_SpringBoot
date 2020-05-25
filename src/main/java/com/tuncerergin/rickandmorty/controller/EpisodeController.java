package com.tuncerergin.rickandmorty.controller;

import com.tuncerergin.rickandmorty.entity.episode.Episode;
import com.tuncerergin.rickandmorty.entity.episode.Result;
import com.tuncerergin.rickandmorty.service.RestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/api")
public class EpisodeController {

    private final RestService restService;

    public EpisodeController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/episode")
    public String listEpisode(@RequestParam(value = "id", required = false, defaultValue = "0") long id,
                              @RequestParam(value = "page", required = false, defaultValue = "0") long page,
                              @RequestParam(value = "sortBy", required = false, defaultValue = "") String sortBy,
                              Model theModel) {
        if (id != 0) {
            Result theEpisode = restService.getEpisode(id);
            theEpisode.setSeason(theEpisode.getEpisode().substring(1, 3));
            theEpisode.setSeasonEpisode(theEpisode.getEpisode().substring(4));

            List<Result> character = new ArrayList<>();
            for (String characterUrl : theEpisode.getCharacters()) {
                Result episodeResult =
                        restService.getCharacter(Long.parseLong(characterUrl.substring(characterUrl.lastIndexOf("/") + 1) + ""));
                character.add(episodeResult);
            }
            theModel.addAttribute("episode", theEpisode);
            theModel.addAttribute("character", character);
            return "episode";
        } else {
            Episode theEpisode = restService.getEpisode(page, sortBy);

            if (sortBy.equals("name")) {
                Comparator<Result> compareById = (Result r1, Result r2) -> r1.getName().compareTo(r2.getName());
                theEpisode.getResults().sort(compareById);
            } else if (sortBy.equals("charactercount")) {
                Comparator<Result> compareById = (Result r1, Result r2) ->
                        (String.valueOf(r1.getCharacters().size())).compareTo(String.valueOf(r2.getCharacters().size()));
                theEpisode.getResults().sort(compareById);
            }
            List<Result> results = new ArrayList<>();
            for (Result result : theEpisode.getResults()) {
                result.setSeason(result.getEpisode().substring(1, 3));
                result.setSeasonEpisode(result.getEpisode().substring(4));
                results.add(result);

            }
            theEpisode.setResults(results);

            int beginIndex = (int) Math.max(1, page - 5);
            int endIndex = (int) Math.min(page + 6, theEpisode.getInfo().getPages() + 1);
            ArrayList<Integer> pagination = new ArrayList<Integer>();
            for (int i = beginIndex; i < endIndex; i++)
                pagination.add(i);
            theModel.addAttribute("pagination", pagination);
            //add customers to the model
            theModel.addAttribute("episode", theEpisode);
            return "list-episode";
        }
    }
}
