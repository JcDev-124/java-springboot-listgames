package com.game.list.services;

import com.game.list.domain.entities.Game;
import com.game.list.domain.records.GameMinDTO;
import com.game.list.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;


    public List<GameMinDTO> getAllGamesMin(){
        List<Game> list = gameRepository.findAll();
        return list.stream().map( x ->
                new GameMinDTO(x.getId(),x.getTitle(),x.getYear(),x.getImgUrl(),x.getShortDescription()))
                .toList();
    }
}
