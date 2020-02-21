package com.example.firstmodule.items;

public class Counter {
    private int numberOfClicks = 0;

    public int getNumberOfClicks() {
        return numberOfClicks;
    }

    public void setNumberOfClicks(int numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }

    public void increaseNumberOfClicks() {
        numberOfClicks++;
    }
}
