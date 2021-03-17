package com.epam.aqa.models;

public class ProcessData {
    protected String currentPriceInCalculator;
    protected String currentEmail;
    protected String currentBrowser;
    protected String currentSearchQuery;

    public String getCurrentPriceInCalculator() {
        return currentPriceInCalculator;
    }

    public void setCurrentPriceInCalculator(String currentPriceInCalculator) {
        this.currentPriceInCalculator = currentPriceInCalculator;
    }

    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    public String getCurrentBrowser() {
        return currentBrowser;
    }

    public void setCurrentBrowser(String currentBrowser) {
        this.currentBrowser = currentBrowser;
    }

    public String getCurrentSearchQuery() {
        return currentSearchQuery;
    }

    public void setCurrentSearchQuery(String currentSearchQuery) {
        this.currentSearchQuery = currentSearchQuery;
    }
}
