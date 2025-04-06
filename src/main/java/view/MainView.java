package view;

import designPatterns.Observer;
import view.mainPanelsCreator.mainPanels.MainPanelController;
import view.mainPanelsCreator.mainPanels.mid.MiddlePanel;
import view.mainPanelsCreator.mainPanels.top.TopPanelController;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame implements Observer<String> {

    private TopPanelController top;

    private MainPanelController mainPanelController;

    private MiddlePanel middlePanel;

    private JLabel timeLabel;

    public MainView() {
        timeLabel = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(new BorderLayout(10, 0));
        setVisible(true);

        top = new TopPanelController(timeLabel);
        mainPanelController = new MainPanelController(this);
        middlePanel = new MiddlePanel();

        mainPanelController.setTopPanel(top.addTime());
        mainPanelController.setMiddleGrid(middlePanel);
    }

    public TopPanelController getTopPanelController() {
        return top;
    }

    public void updateProgressBar(int progressBar) {
        middlePanel.updateProgress(progressBar);
    }

    @Override
    public void update(String time) {
        timeLabel.setText(time);
    }
}
