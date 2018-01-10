package com.consilium.genium.cardengine.decks;

import com.consilium.genium.cardengine.cards.Card;
import com.consilium.genium.cardengine.cards.CardType;
import com.consilium.genium.cardengine.cards.SimpleCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
public class DeckTest {

    private static final int DECK_SIZE = 50;

    private Deck deck;

    @Before
    public void setup() {
        deck = new DrawDeck();
        IntStream.rangeClosed(1, DECK_SIZE)
                .forEach(i -> deck.addToTop(new SimpleCard(Integer.toString(i), CardType.BEING)));
    }

    @Test
    public void drawCardTest() {
        Card card = this.deck.draw();
        assertThat("Deck size should be one less after drawing", this.deck.size(), is(DECK_SIZE - 1));
        assertThat("The first card was drawn", card.getName(), is("50"));
        assertNotNull("The deck should have a gameId", this.deck.getGameId());
        assertNotNull("The card should have a gameId", card.getGameId());
    }
}
