package com.game.list.services;

import com.game.list.domain.entities.Game;
import com.game.list.domain.entities.GameList;
import com.game.list.domain.records.GameListDTO;
import com.game.list.domain.records.GameMinDTO;
import com.game.list.projections.GameMinProjection;
import com.game.list.repositories.GameListRepository;
import com.game.list.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public void createdList(GameListDTO dto){
        GameList list = new GameList(dto.id(), dto.name());
        gameListRepository.save(list);
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> getAllGameList(){
        List<GameList> list = gameListRepository.findAll();
        return list.stream().map(x -> new GameListDTO(x.getId(), x.getName())).toList();
    }

    @Transactional
    public void moveGameOnList(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for( int i = min; i <= max; i++)
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);

    }
}
