package src.games.poker;

import src.Card;

import java.util.*;
import java.util.function.Consumer;

public class PokerGame {

    private final List<Card> deck = Card.getStandardDeck();
    private int playerCount;
    private int cardsInHands;
    private List<PokerHand> pokerHands;
    private List<Card> remainingCards;

    public PokerGame(int playerCount, int cardsInHands) {
        this.playerCount = playerCount;
        this.cardsInHands = cardsInHands;
        pokerHands = new ArrayList<>(cardsInHands);
    }

    public void startPlay(){

        Collections.shuffle(deck);
        int random = new Random().nextInt(15,35);
        Collections.rotate(deck,random);
        deal();
        System.out.println();
        Consumer<PokerHand> checkHand = PokerHand::evalHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));

        int cardsDealt = playerCount * cardsInHands;
        int cardRemaining = deck.size() - cardsDealt;

        Card.printDeck(deck);
        remainingCards = new ArrayList<>(Collections.nCopies(cardRemaining,null));
        remainingCards.replaceAll(c -> deck.get(cardsDealt + remainingCards.indexOf(c)));
//        remainingCards = new ArrayList<>(deck.subList(cardsDealt,deck.size()));
        Card.printDeck(remainingCards);
    }


    public void deal(){

        Card[][] hands = new Card[playerCount][cardsInHands];
        for(int deckIndex = 0,i = 0;i < cardsInHands;i++){
            for (int j = 0;j < playerCount;j++){
                hands[j][i] = deck.get(deckIndex++);
            }
        }

        int playerNo = 1;
        for (Card[] hand : hands){
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }
    }
}
