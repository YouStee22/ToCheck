package controller;

import logic.simulator.GameSimulation;
import logic.simulator.ProgressBarDecreaser;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class MainController {

    private MainView mainView;
    private GameSimulation gameSimulation;
    private ProgressBarDecreaser decreaser;

    public MainController(MainView mainView, GameSimulation gameSimulation) {
        this.mainView = mainView;
        this.gameSimulation = gameSimulation;
        this.decreaser = new ProgressBarDecreaser();

        mainView.getTopPanelController().addSpeedButtonListener(e -> handleSpeedButtonClick());

        gameSimulation.setCalendar();
        gameSimulation.toggleMonitoring();

        mainView.getTopPanelController().addPauseButtonListener(e -> {
            mainView.getTopPanelController().setPlayButton();
            gameSimulation.toggleMonitoring();
        });

        executeTask();
    }

    public void executeTask() {                                                 //Jak to przenieść do GameSimulation? bo wtedy nie będzie
        Timer timer = new Timer();                                              //dostepu do mainView? Czy GameSimulation powinno wiedzieć o
        timer.scheduleAtFixedRate(new TimerTask() {                             // mainView?
            @Override
            public void run() {
                mainView.updateProgressBar(decreaser.countryChooser());
            }
        }, 0, 150);
    }

    private void handleSpeedButtonClick() {
        if (gameSimulation.getTimeSpeed() == 1000) {
            gameSimulation.setTimeSpeedAndUpdate(50, 1500);
            mainView.getTopPanelController().increaseSpeedButton("X4");
        } else if (gameSimulation.getTimeSpeed() == 50) {
            gameSimulation.setTimeSpeedAndUpdate(10, 1250);
            mainView.getTopPanelController().increaseSpeedButton("8");
        } else if (gameSimulation.getTimeSpeed() == 10) {
            gameSimulation.setTimeSpeedAndUpdate(1, 1000);
            mainView.getTopPanelController().increaseSpeedButton("X16");
        } else if (gameSimulation.getTimeSpeed() == 1) {
            gameSimulation.setTimeSpeedAndUpdate(1000, 2000);
            mainView.getTopPanelController().increaseSpeedButton("X1");
        }
        gameSimulation.setCalendar();
    }
}
