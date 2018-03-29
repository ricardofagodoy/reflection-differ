package io.github.ricardofagodoy.objects;

import java.util.HashSet;
import java.util.Set;

public class Person {

    private final String name;
    private String phoneNumber;
    private final Set<Card> cards;

    public Person(String name) {
        this.name = name;
        this.cards = new HashSet<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void blockCard(String lastNumbers) {
        this.cards.stream().
                filter(card -> card.getLastNumbers().equals(lastNumbers)).
                findFirst().
                ifPresent(Card::block);
    }

    public void changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deleteAllCards() {
        this.cards.clear();
    }

    @Override
    public String toString() {
        return String.format("%s (%s) has %d cards", name, phoneNumber, cards.size());
    }
}