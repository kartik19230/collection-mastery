package src;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {

    public enum Suit{

        CLUB,DIAMOND,HEART,SPADE;

        public char getImage(){
            char[] ch = {9827,9830,9829,9824};
            return ch[this.ordinal()];
        }
    }

    @Override
    public String toString() {

        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0,index);
        return "%s%c(%d)".formatted(face,suit.getImage(),rank);
    }

    public static Card getNumericCard(Suit suit,int cardNumber){

        if (cardNumber > 1 && cardNumber < 11){
            return new Card(suit,String.valueOf(cardNumber),cardNumber-2);
        }
        System.out.println("Invalid Numeric Card Selected");
        return null;
    }

    public static Card getFaceCard(Suit suit,char abbrev){

        int charIndex = "JQKA".indexOf(abbrev);

        if (charIndex > -1){
            return new Card(suit,"" + abbrev,charIndex + 9);
        }

        System.out.println("Invalid Face Card Selected");

        return null;
    }

    public static List<Card> getStandardDeck(){

        List<Card> deck = new ArrayList<>(52);

        for (Suit suit :
                Suit.values()) {
            for (int i = 2; i <= 10; i++) {
                deck.add(getNumericCard(suit,i));
            }
            for (char ch :
                    new char[]{'J','Q','K','A'}) {
                deck.add(getFaceCard(suit,ch));
            }
        }

        return deck;
    }

    public static void printDeck(List<Card> deck,String description,int rows){

        System.out.println("-----------------------------");

        if (description != null){
            System.out.println(description);
        }

        int cardInRow = deck.size()/rows;
        for (int i = 0; i < rows; i++) {

            int startIndex = i * cardInRow;
            int endIndex = startIndex + cardInRow;
            deck.subList(startIndex,endIndex).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    public static void printDeck(List<Card> deck){

        printDeck(deck,"Current Deck",4);
    }
}
