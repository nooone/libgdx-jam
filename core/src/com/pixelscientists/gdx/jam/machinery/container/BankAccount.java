package com.pixelscientists.gdx.jam.machinery.container;

/**
 * @author Daniel Holderbaum
 */
public class BankAccount {

    private float credits = 0;

    public float getCredits() {
        return credits;
    }

    public void changeCredits(float deltaCredits) {
        this.credits += deltaCredits;
    }
}
