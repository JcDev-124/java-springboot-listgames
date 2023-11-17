package com.game.list.controllers;

import com.game.list.domain.records.GameListDTO;
import com.game.list.domain.records.GameMinDTO;
import com.game.list.domain.records.ReplacementDTO;
import com.game.list.services.GameListService;
import com.game.list.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameListDTO>    getAllGameList(){
        return gameListService.getAllGameList();
    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> getAllGamesByList(@PathVariable Long id){
        return gameService.getAllGamesMinByList(id);
    }

    @PostMapping(value = "/{listId}/move")
    public void moveGameOnList(@PathVariable Long listId, @RequestBody ReplacementDTO body){
            gameListService.moveGameOnList(listId, body.sourceIndex(), body.destinationIndex());
    }

    @PostMapping
    public void createdList(@RequestBody GameListDTO dto){
        gameListService.createdList(dto);
    }
}
