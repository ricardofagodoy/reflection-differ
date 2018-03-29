package io.github.ricardofagodoy.objects;

public class Card {

    private final String lastNumbers;
    private Boolean active;

    public Card(String lastNumbers) {
        this.lastNumbers = lastNumbers;
        this.active = true;
    }

    public String getLastNumbers() {
        return lastNumbers;
    }

    public Boolean isActive() {
        return active;
    }

    public void block() {
        this.active = false;
    }

    @Override
    public int hashCode() {
        return lastNumbers.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o instanceof Card) {

            Card c = (Card) o;

            return c.getLastNumbers().equals(this.lastNumbers) &&
                   c.isActive().equals(this.active);
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("Card ending in %s is %s", lastNumbers, active ? "active" : "blocked");
    }
}