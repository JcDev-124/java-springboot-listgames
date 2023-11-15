package com.game.list.services;

import com.game.list.domain.entities.Game;
import com.game.list.domain.entities.GameList;
import com.game.list.domain.records.GameListDTO;
import com.game.list.domain.records.GameMinDTO;
import com.game.list.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> getAllGameList(){
        List<GameList> list = gameListRepository.findAll();
        return list.stream().map(x -> new GameListDTO(x.getId(), x.getName())).toList();
    }
}
