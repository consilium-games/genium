package com.consilium.genium.cardengine.game;

import com.consilium.genium.cardengine.cards.Card;
import com.consilium.genium.cardengine.decks.DiscardDeck;
import com.consilium.genium.cardengine.decks.DrawDeck;
import com.consilium.genium.cardengine.decks.RemoveFromPlayDeck;

import java.util.*;
import java.util.stream.IntStream;

public class Player extends GameObject {
    private String name;
    private DrawDeck drawDeck;
    private DiscardDeck discardDeck;
    private RemoveFromPlayDeck removeFromPlayDeck;
    private Map<String, Card> hand;

    public Player(String name) {
        this.name = name;
        this.drawDeck = new DrawDeck();
        this.discardDeck = new DiscardDeck();
        this.removeFromPlayDeck = new RemoveFromPlayDeck();
        this.hand = new HashMap<>();
    }

    public void drawCard() {
        Card card = this.drawDeck.draw();
        hand.put(card.getGameId(), card);
    }

    public void drawCards(int numberOfCardsToDraw) {
        List<Card> cards = this.drawDeck.draw(numberOfCardsToDraw);
        cards.forEach(card -> hand.put(card.getGameId(), card));
    }

    public void discardCard(Card card) {
        this.hand.remove(card.getGameId());
    }

    public void discardCards(List<Card> cards) {
        cards.forEach(card -> discardCard(card));
    }

    public void discardRandomCard() {
        List<String> keysAsArray = new ArrayList<String>(this.hand.keySet());
        Random r = new Random();
        Card removedCard = this.hand.remove(keysAsArray.get(r.nextInt(keysAsArray.size())));
        this.discardDeck.
    }

    public void discardRandomCards(int numberToDiscard) {
        IntStream.rangeClosed(1, numberToDiscard)
                .forEach(i -> discardRandomCard());
    }

}
