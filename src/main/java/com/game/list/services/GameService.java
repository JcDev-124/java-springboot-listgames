package com.game.list.services;

import com.game.list.domain.entities.Game;
import com.game.list.domain.records.GameDTO;
import com.game.list.domain.records.GameMinDTO;
import com.game.list.projections.GameMinProjection;
import com.game.list.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;


    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> getAllGamesMin(){
        List<Game> list = gameRepository.findAll();
        return list.stream().map( x ->
                new GameMinDTO(x.getId(),x.getTitle(),x.getYear(),x.getImgUrl(),x.getShortDescription()))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> getAllGamesMinByList(Long listId){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        return list.stream().map( x ->
                        new GameMinDTO(x.getId(),x.getTitle(),x.getYear(),x.getImgUrl(),x.getShortDescription()))
                .toList();
    }

}
