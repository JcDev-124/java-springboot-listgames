package com.game.list.controllers;

import com.game.list.domain.entities.Game;
import com.game.list.domain.records.GameDTO;
import com.game.list.domain.records.GameMinDTO;
import com.game.list.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameMinDTO> getAllGamesMin(){
        return gameService.getAllGamesMin();
    }

    @GetMapping(value = "/{id}")
    public GameDTO getGameById(@PathVariable Long id){
        return gameService.findById(id);
    }
}
