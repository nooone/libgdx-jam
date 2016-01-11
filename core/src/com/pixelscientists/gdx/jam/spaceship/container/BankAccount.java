package com.pixelscientists.gdx.jam.spaceship.container;

/**
 * @author Daniel Holderbaum
 */
public class BankAccount {

    private float credits = 0;

    public float getCredits() {
        return credits;
    }

    public void deposit(float credits) {
        assert credits >= 0;
        this.credits += credits;
    }

    public void withdraw(float credits) {
        assert credits >= 0;
        this.credits -= credits;
    }

}
