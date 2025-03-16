package view;

import designPatterns.ObserverTimer;
import view.mainPanelsCreator.MainController;
import view.mainPanelsCreator.mainPanels.MainPanelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame implements ObserverTimer {

    private MainController mainController;


    private JButton speedButton = new JButton("X1");
    private JButton stopButton = new JButton("PLAY");
    private JLabel timeLabel = new JLabel();


    public MainView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(new BorderLayout(10, 0));
        setVisible(true);
        mainController = new MainController(new MainPanelController(this),
                speedButton, stopButton, timeLabel);
    }

    public void addSpeedButtonListener(ActionListener listener) {
        speedButton.addActionListener(listener);
    }

    public void setPlayButton() {
        if (stopButton.getText().equals("PLAY"))
            stopButton.setText("PAUSE");
        else
            stopButton.setText("PLAY");
    }

    public void addPauseButtonListener(ActionListener listener) {
        stopButton.addActionListener(listener);
    }


    public void increaseSpeedButton(String text) {
        speedButton.setText(text);
    }

    @Override
    public void update(String date) {
        timeLabel.setText(date);
    }


}
