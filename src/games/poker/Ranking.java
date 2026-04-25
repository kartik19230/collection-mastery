package src.games.poker;

public enum Ranking {

    NONE,ONE_PAIR,TW0_PAIR,THREE_OF_A_KIND,FULL_HOUSE,FOUR_OF_A_KIND;

    @Override
    public String toString() {
        return this.name().replace('_',' ');
    }
}
