package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    // Control the computer AI
    static private int scoreToHit = 16;

    private String name;
    private Hand hand;
    private int potValue;

    /**
     * Construct a new player
     * @param name The player's name
     * @param potValue The current amount of money the player has
     */
    public Player(String name, int potValue) {
        this.name = name;
        this.potValue = potValue;
        this.hand = new Hand();
    }

    /**
     * Handle the computer AI
     * @return True if we want a new card, false otherwise
     */
    public boolean computerAI() {
        this.hand.scoreHand();
        return (this.hand.getHandScore() < scoreToHit);
    }

    /**
     * @return The player's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The player's new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The player's current pot
     */
    public int getPotValue() {
        return potValue;
    }

    /**
     * @param potValue The player's new pot
     */
    public void setPotValue(int potValue) {
        this.potValue = potValue;
    }

    /**
     * @return The player's hand
     */
    public Hand getHand() {
        return hand;
    }
}
