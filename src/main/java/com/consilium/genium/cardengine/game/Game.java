package com.consilium.genium.cardengine.game;

import java.util.*;

public class Game extends GameObject {
    private String name;
    private Map<String, Player> players;
    private Map<String, Spectator> spectators;

    public Game(String name)  {
        this.name = name;
        this.players = new HashMap<>();
        this.spectators = new HashMap<>();
    }

    public void addPlayer(Player player) {
        this.players.put(player.getGameId(), player);
    }

    public void addSpectator(Spectator spectator) {
        this.spectators.put(spectator.getGameId(), spectator);
    }

    public String getName() {
        return name;
    }
}
