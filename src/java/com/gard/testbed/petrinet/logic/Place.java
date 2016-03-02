package com.gard.testbed.petrinet.logic;

/**
 * Created by Chris on 01/03/2016.
 */
public class Place
        extends PetrinetObject {

    // it's a magic number....
    public static final int UNLIMITED = -1;

    private int tokens = 0;
    private int maxTokens = UNLIMITED;


    protected Place(String name) {
        super(name);
    }

    protected Place(String name, int initial) {
        this(name);
        this.tokens = initial;
    }

    /**
     * Checks if place holds required number of tokens
     *
     * @param threshold
     * @return
     */
    public boolean hasAtLeastTokens(int threshold) {
        return (tokens >= threshold);
    }

    /**
     * Manages maximum number of tokens
     *
     * @param newTokens
     * @return
     */
    public boolean maxTokensReached(int newTokens) {
        if (hasUnlimitedMaxTokens()) {
            return false;
        }

        return (tokens+newTokens > maxTokens);
    }

    private boolean hasUnlimitedMaxTokens() {
        return maxTokens == UNLIMITED;
    }


    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void setMaxTokens(int max) {
        this.maxTokens = max;
    }

    public void addTokens(int weight) {
        this.tokens += weight;
        System.out.println("ADDTOKENS in: " + getName());
    }

    public void removeTokens(int weight) {
        this.tokens -= weight;
        System.out.println("REMOVETOKENS in: " + getName());
    }


    @Override
    public String toString() {
        return super.toString() +
                " Tokens=" + this.tokens +
                " max=" + (hasUnlimitedMaxTokens()? "unlimited" : this.maxTokens);
    }
}
