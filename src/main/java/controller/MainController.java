package controller;

import logic.threadController.ThreadsController;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private MainView mainView;
    private ThreadsController threadsController;


    public MainController(MainView mainView, ThreadsController threadsController) {
        this.mainView = mainView;
        this.threadsController = threadsController;

        mainView.addSpeedButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSpeedButtonClick();
            }
        });
        threadsController.setCalendar();
        threadsController.startMonitoring();

        mainView.addPauseButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setPlayButton();
                threadsController.startMonitoring();
            }
        });
    }

    private void handleSpeedButtonClick() {
        if (threadsController.getTimeSpeed() == 1000) {
            threadsController.setTimeSpeedAndUpdate(50, 1500);
            mainView.increaseSpeedButton("X4");
        } else if (threadsController.getTimeSpeed() == 50) {
            threadsController.setTimeSpeedAndUpdate(10, 1250);
            mainView.increaseSpeedButton("X8");
        } else if (threadsController.getTimeSpeed() == 10) {
            threadsController.setTimeSpeedAndUpdate(1, 1000);
            mainView.increaseSpeedButton("X16");
        } else if (threadsController.getTimeSpeed() == 1) {
            threadsController.setTimeSpeedAndUpdate(1000, 2000);
            mainView.increaseSpeedButton("X1");
        }

        threadsController.setCalendar();
    }
}
