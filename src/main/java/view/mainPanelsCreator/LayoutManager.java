package view.mainPanelsCreator;

import view.mainPanelsCreator.mainPanels.MainPanelController;
import view.mainPanelsCreator.mainPanels.mid.MiddlePanel;
import view.mainPanelsCreator.mainPanels.top.TopPanelController;

import javax.swing.*;

public class LayoutManager {

    private TopPanelController top;

    private MainPanelController mainPanelController;

    private MiddlePanel middlePanel;

    public LayoutManager(MainPanelController mainPanelController, JLabel timeLabel, JPanel middlePanel) {
        top = new TopPanelController(timeLabel);
        this.middlePanel = new MiddlePanel();
        this.mainPanelController = mainPanelController;

        setTopPanel();
        setCenterPanel();
    }

//    public JButton getSpeed_button() {
//        return top.getSpeed_button();
//    }
//
//    public JButton getStop_button() {
//        return top.getStop_button();
//    }

    public TopPanelController getTop() {
        return top;
    }

    public void setTopPanel() {
        mainPanelController.setTopPanel(top.addTime());
    }

    public MiddlePanel getMiddlePanel() {
        return middlePanel;
    }

    public void setCenterPanel() {
        mainPanelController.setMiddleGrid(middlePanel);
    }

}
