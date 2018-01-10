package com.consilium.genium.cardengine.cards;

import com.consilium.genium.cardengine.game.GameObject;

public abstract class Card extends GameObject {

    private String name;
    private CardType type;

    public Card(String name, CardType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
}
