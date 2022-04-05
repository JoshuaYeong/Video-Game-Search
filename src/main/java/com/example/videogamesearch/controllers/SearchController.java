package com.example.videogamesearch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.videogamesearch.models.Game;
import com.example.videogamesearch.service.SearchService;

@Controller
@RequestMapping(path="/search")
public class SearchController {

    @Autowired 
    private SearchService searchSvc;

    // http://localhost:8080/search?search_name=abc&number_of_results=5

    @GetMapping
    public String gameSearch(@RequestParam(name="search_name") String searchName, 
            @RequestParam(name="number_of_result", defaultValue="10") Integer numOfResults, Model model)
        {

            System.out.printf(">>> Search Name: %s\n", searchName);
            System.out.printf(">>> Number of Results: %d\n", numOfResults);

            if (numOfResults == 0)
                return "empty";
            else if(numOfResults > 20)
                return "error";
            
            List<Game> listOfGames = searchSvc.search(searchName, numOfResults);

            if (listOfGames.isEmpty())
                return "empty";

            model.addAttribute("search_name", searchName);
            model.addAttribute("number_of_result", numOfResults);
            model.addAttribute("games", listOfGames);

            // System.out.println(">>>>>>>> Game List: " + listOfGames);

            return "game";
        }

}
