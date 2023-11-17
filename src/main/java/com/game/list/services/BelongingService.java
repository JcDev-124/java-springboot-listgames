package com.game.list.services;

import com.game.list.domain.entities.Belonging;
import com.game.list.domain.records.BelongingDTO;
import com.game.list.repositories.BelongingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BelongingService {

    @Autowired
    private BelongingRepository belongingRepository;

    @Transactional
    public void createdBelonging(BelongingDTO dto){
        Belonging belonging = new Belonging(dto.game(), dto.list(), dto.position());
        belongingRepository.save(belonging);

    }
}
