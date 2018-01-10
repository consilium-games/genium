package com.consilium.genium.cardengine.decks;

import com.consilium.genium.cardengine.cards.Card;
import com.consilium.genium.cardengine.game.GameObject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public abstract class Deck extends GameObject {
    private LinkedList<Card> cards;

    public Deck() {
        this.cards = new LinkedList<>();
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card draw() {
        return this.cards.removeFirst();
    }

    public List<Card> draw(int numberToDraw) {
        List<Card> cardsToDraw = new LinkedList<>();
        IntStream.rangeClosed(1, numberToDraw)
                .forEach(i -> cardsToDraw.add(this.draw()));
        return cardsToDraw;
    }

    public Card drawBottom() {
        return this.cards.removeLast();
    }

    public List<Card> drawBottom(int numberToDraw) {
        List<Card> cardsToDraw = new LinkedList<>();
        IntStream.rangeClosed(1, numberToDraw)
                .forEach(i -> cardsToDraw.add(this.drawBottom()));
        return cardsToDraw;
    }

    public List<Card> lookAtTop(int numberToLookAt) {
        return this.cards.subList(0, numberToLookAt - 1);
    }

    public List<Card> lookAtBottom(int numberToLookAt) {
        return this.cards.subList(this.cards.size() - numberToLookAt, this.cards.size() - 1);
    }

    public void addToTop(Card card) {
        this.cards.addFirst(card);
    }

    public void addToTop(List<Card> cards) {
        cards.forEach(card -> this.addToTop(card));
    }

    public void addToBottom(Card card) {
        this.cards.addLast(card);
    }

    public void addToBottom(List<Card> cards) {
        cards.forEach(card -> this.addToBottom(card));
    }

    public List<Card> search() {
        return cards;
    }

    public int size() {
        return this.cards.size();
    }
}
