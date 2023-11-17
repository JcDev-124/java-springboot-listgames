package com.game.list.domain.records;

import com.game.list.domain.entities.Game;
import com.game.list.domain.entities.GameList;

public record BelongingDTO(Game game, GameList list, Integer position) {
}
