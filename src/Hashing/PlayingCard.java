package src.Hashing;

public class PlayingCard {

    private String face;
    private String suit;
    private int interalHash;

    public PlayingCard(String face, String suit) {
        this.face = face;
        this.suit = suit;
        this.interalHash = 1;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;

        if (!face.equals(that.face)) return false;
        return suit.equals(that.suit);
    }

    @Override
    public int hashCode() {
        int result = face.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }
}
