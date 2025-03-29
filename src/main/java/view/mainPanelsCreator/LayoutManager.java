package view.mainPanelsCreator;

import view.mainPanelsCreator.mainPanels.MainPanelController;
import view.mainPanelsCreator.mainPanels.mid.MiddlePanel;
import view.mainPanelsCreator.mainPanels.top.TopPanelController;

import javax.swing.*;

public class MainController {

    private TopPanelController top;

    private MainPanelController mainPanelController;

    private MiddlePanel middlePanel;

    public MainController(MainPanelController mainPanelController, JButton stopButton, JButton SPEED_BUTTON, JLabel timeLabel, JPanel middlePanel) {
        top = new TopPanelController(SPEED_BUTTON, stopButton, timeLabel);
        this.middlePanel = new MiddlePanel(middlePanel);
        this.mainPanelController = mainPanelController;

        setTopPanel();
        setCenterPanel();
    }

    public void setTopPanel() {
        mainPanelController.setTopPanel(top.addTime());
    }
    public void setCenterPanel() {
        mainPanelController.setMiddleGrid(middlePanel);
    }

}
