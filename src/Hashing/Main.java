package src.Hashing;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l","He","lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> text = new ArrayList<>(Arrays.asList(
                aText,bText,cText,dText,eText
        ));
        text.forEach(s -> System.out.println(s + " : " +  s.hashCode()));

        Set<String> set = new HashSet<>(text);
        System.out.println(set + " Size of set = " + set.size());

        for (String setValue :
                set) {
            System.out.print(setValue + " : ");
            for (int i = 0; i < text.size(); i++) {
                if (setValue == text.get(i)){
                    System.out.print(i + ", ");
                }
            }
            System.out.println();
        }

        PlayingCard kingOfSpades = new PlayingCard("King","Spade");
        PlayingCard aceOfHearts = new PlayingCard("Ace","Hearts");

        PlayingCard jackOfClub = new PlayingCard("Jack","Club");

        List<PlayingCard> cards = new ArrayList<>(
                Arrays.asList(kingOfSpades,aceOfHearts,jackOfClub)
        );
        cards.forEach(s -> System.out.println(s + " = " + s.hashCode()));

        Set<PlayingCard> deck = new HashSet<>();

        for (PlayingCard c : cards){
            if (!deck.add(c)){
                System.out.println("Found a duplicate for " + c);
            }
        }
        System.out.println(deck);
    }
}
