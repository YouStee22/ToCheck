package view.mainPanelsCreator;

import view.mainPanelsCreator.mainPanels.MainPanelController;
import view.mainPanelsCreator.mainPanels.top.TopPanelController;

import javax.swing.*;

public class MainController {

    private TopPanelController top;

    private MainPanelController mainPanelController;

    public MainController(MainPanelController mainPanelController, JButton stopButton, JButton SPEED_BUTTON, JLabel timeLabel) {
        top = new TopPanelController(SPEED_BUTTON, stopButton, timeLabel);
        this.mainPanelController = mainPanelController;

        setTopPanel();
    }

    public void setTopPanel() {
        mainPanelController.setTopPanel(top.addTime());
    }

}
