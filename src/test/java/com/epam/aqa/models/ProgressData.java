package com.epam.aqa.models;

public class ProgressData {
    protected String currentPriceInCalculator;
    protected String currentEmail;

    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    public String getCurrentPriceInCalculator() {
        return currentPriceInCalculator;
    }

    public void setCurrentPriceInCalculator(String currentPriceInCalculator) {
        this.currentPriceInCalculator = currentPriceInCalculator;
    }
}
