package com.game.list.repositories;

import com.game.list.domain.entities.Belonging;
import com.game.list.domain.entities.BelongingPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BelongingRepository extends JpaRepository<Belonging, BelongingPK> {
}
