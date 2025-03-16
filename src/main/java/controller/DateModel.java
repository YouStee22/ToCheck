package controller;

import designPatterns.ObserverTimer;

import java.util.ArrayList;
import java.util.List;

public class DateModel {
    private String currentDate;
    private List<ObserverTimer> observerTimers = new ArrayList<>();

    public void addObserver(ObserverTimer observerTimer) {
        observerTimers.add(observerTimer);
    }

    public void removeObserver(ObserverTimer observerTimer) {
        observerTimers.remove(observerTimer);
    }

    public void setDate(String newDate) {
        this.currentDate = newDate;
        notifyObservers();
    }

    private void notifyObservers() {
        for (ObserverTimer observerTimer : observerTimers) {
            observerTimer.update(currentDate);
        }
    }

    public String getDate() {
        return currentDate;
    }
}