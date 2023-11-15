package com.game.list.controllers;

import com.game.list.domain.records.GameListDTO;
import com.game.list.domain.records.GameMinDTO;
import com.game.list.services.GameListService;
import com.game.list.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameListDTO>    getAllGameList(){
        return gameListService.getAllGameList();
    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> getAllGamesByList(@PathVariable Long id){
        return gameService.getAllGamesMinByList(id);
    }
}
