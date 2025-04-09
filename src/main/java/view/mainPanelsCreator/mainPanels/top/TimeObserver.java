package view.mainPanelsCreator.mainPanels.top;

import designPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class TimeObserver {

    private String currentDate;

    private List<Observer<String>> observers = new ArrayList<>();

    public void addObserver(Observer<String> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    public void setDate(String newDate) {
        this.currentDate = newDate;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer<String> observer : observers) {
            observer.update(currentDate);
        }
    }

    public String getDate() {
        return currentDate;
    }
}