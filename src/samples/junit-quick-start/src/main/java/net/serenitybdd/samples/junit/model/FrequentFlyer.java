package net.serenitybdd.samples.junit.model;

/**
 * Created by john on 22/11/14.
 */
public class FrequentFlyer {

    private int balance;

    public static FrequentFlyer withInitialBalanceOf(int initialBalance) {
        return new FrequentFlyer(initialBalance);
    }

    public FrequentFlyer(int balance) {
        this.balance = balance;
    }

    public PointCumulator flies(int distance) {
        return new PointCumulator(distance);
    }

    public int getBalance() {
        return balance;
    }

    public class PointCumulator {
        int distance;

        public PointCumulator(int distance) {
            this.distance = distance;
        }

        public void kilometers() {
            incrementBalanceBy(distance / 10);
        }
    }

    protected void incrementBalanceBy(int points) {
        this.balance += points;
    }
}
