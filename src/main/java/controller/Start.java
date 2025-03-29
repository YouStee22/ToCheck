package controller;

import logic.simulator.GameSimulation;
import models.TimeObserver;
import view.MainView;

public class Start {
    public static void main(String[] args) {
        MainView view = new MainView();
        TimeObserver timeObserver = new TimeObserver();

        GameSimulation gameSimulation = new GameSimulation(timeObserver);
        new MainController(view, gameSimulation);

        timeObserver.addObserver(view);
    }
}
