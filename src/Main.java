package src;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("This is my Collection Mastery class");

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
    }
}
