package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("This is my Collection Mastery class");

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART,'A');
        Arrays.fill(cardArray,aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray),"Ace of Hearts(cardArray)",1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards,aceOfHearts);
        System.out.println(cards);
        System.out.println(cards.size() + " Size of Cards");

        List<Card> aceOfHeart = Collections.nCopies(13,aceOfHearts);
        Card.printDeck(aceOfHeart,"Ace of Heart's(aceOfHearts)",1);

        Card kingsOfSpade = Card.getFaceCard(Card.Suit.SPADE,'K');
        List<Card> kingsOfSpades = Collections.nCopies(13,kingsOfSpade);
        Card.printDeck(kingsOfSpades,"Kings Of Spade(kingOfSpades)",1);

        Card kingsOfClub = Card.getFaceCard(Card.Suit.CLUB,'K');
        Card[] clubArray = new Card[13];
        Arrays.fill(clubArray,kingsOfClub);

        Collections.addAll(cards,cardArray);
        Collections.addAll(cards,clubArray);
        Card.printDeck(cards,"Cards collection added with aces of heart and Kings of club(Cards)",2);

        //Copied the list
        Collections.copy(cards,kingsOfSpades);
        Card.printDeck(cards,"Cards copied from King of Spade(Cards)",2);

        //Returned Copy of the list
        cards = List.copyOf(kingsOfSpades);
        Card.printDeck(cards,"Created a copy of king of spades(Cards)",1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck,"Shuffled Deck",4);

        Collections.reverse(deck);
        Card.printDeck(deck,"Shuffled Deck",4);

        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck,sortingAlgorithm);
        Card.printDeck(deck,"Sorting the deck",13);

        Collections.reverse(deck);
        Card.printDeck(deck,"Reverse the Sorted Deck",13);

        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings,"Kings in the deck",1);

        List<Card> ten = new ArrayList<>(deck.subList(16,20));
        Card.printDeck(ten,"Tens in the deck",1);

        int subListIndex = Collections.indexOfSubList(deck,ten);
        System.out.println("The SubList Index of the Ten = " + subListIndex);
        System.out.println("The List Contains Kings = " + deck.containsAll(kings));

        System.out.println("Are there andy Common elements = "+ Collections.disjoint(ten,kings));
        System.out.println("Are there andy Common elements = "+ Collections.disjoint(deck,kings));

        //Performing binary search using Collections

        deck.sort(sortingAlgorithm);
        Card tenOfSpades = Card.getNumericCard(Card.Suit.SPADE,10);
        int foundIndex = Collections.binarySearch(deck,tenOfSpades,sortingAlgorithm);
        System.out.println("Element at index = " + foundIndex);
        System.out.println("Targeted Element = " + deck.get(foundIndex));

        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART,10);
        Collections.replaceAll(deck,tenOfSpades,tenOfHearts);
        Card.printDeck(deck.subList(32,36),"Replacing Spades of Ten",1);

        Collections.replaceAll(deck,tenOfHearts,tenOfSpades);
        Card.printDeck(deck.subList(32,36),"Replacing Heart of Ten",1);

        if (Collections.replaceAll(deck,tenOfHearts,tenOfSpades)){
            System.out.println("Replaced the Heart of ten");
        }else{
            System.out.println("Element not found");
        }

        //Checking Duplicates using frequency methods
        System.out.println("How many Duplicate elements are present inside list = " +
                Collections.frequency(deck,tenOfSpades));

        System.out.println("Best Card " + Collections.max(deck,sortingAlgorithm));
        System.out.println("Worst Card " + Collections.min(deck,sortingAlgorithm));

        var sortingUsingComaparator = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortingUsingComaparator);
        Card.printDeck(deck,"Sorted Using Comparator",4);

        List<Card> clubs = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(clubs,3);
        System.out.println("UnRotated List = " +  deck.subList(0,13));
        System.out.println("Rotated List = " + clubs);

        clubs = new ArrayList<>(deck.subList(0,13));
        System.out.println(clubs);
        for (int i = 0; i < clubs.size()/2;i++){
            Collections.swap(clubs,i,clubs.size()-i-1);
        }
        System.out.println(clubs);
        Collections.sort(clubs,sortingAlgorithm);
        System.out.println(clubs);


    }
}
