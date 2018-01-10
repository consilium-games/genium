package com.consilium.genium.cardengine.game;

import java.util.UUID;

public abstract class GameObject {

    private String gameId;

    public GameObject() {
        gameId = UUID.randomUUID().toString();
    }

    public String getGameId() {
        return gameId;
    }
}
