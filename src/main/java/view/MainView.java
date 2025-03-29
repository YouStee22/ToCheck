package view;

import designPatterns.Observer;
import view.mainPanelsCreator.LayoutManager;
import view.mainPanelsCreator.mainPanels.MainPanelController;
import view.mainPanelsCreator.mainPanels.top.TopPanelController;

import javax.swing.*;
import java.awt.*;
                                                                                    //Dodanie do interfejsu typu
public class MainView extends JFrame implements Observer<String> {                             //Tylko gettery (udostepnianie widoku)

    private LayoutManager layoutManager;

//    private TopPanelController topPanelController;                                          //przyklad open/close zamiast przyciskow

    private JLabel timeLabel;
    private JPanel gridPanel;


    public MainView() {
        gridPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        timeLabel = new JLabel();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLayout(new BorderLayout(10, 0));
        setVisible(true);
        layoutManager = new LayoutManager(new MainPanelController(this), timeLabel, gridPanel);
    }

    public LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public TopPanelController getTopPanelController() {
        return layoutManager.getTop();
    }

    public void updateProgressBar(int progressBar) {
        layoutManager.getMiddlePanel().updateProgress(progressBar);
    }

    @Override
    public void update(String time) {
        timeLabel.setText(time);
    }


//    public void addSpeedButtonListener(ActionListener listener) {                         //Przeniesienie 4 metod do TopPanelController
//        layoutManager.getTop().getSpeed_button().addActionListener(listener);
//    }
//    public void setPlayButton() {
//        if (layoutManager.getTop().getStop_button().getText().equals("PLAY"))
//            layoutManager.getTop().getStop_button().setText("PAUSE");
//        else
//            layoutManager.getTop().getStop_button().setText("PLAY");
//    }
//    public void addPauseButtonListener(ActionListener listener) {
//        layoutManager.getTop().getStop_button().addActionListener(listener);
//    }
//    public void increaseSpeedButton(String text) {
//        layoutManager.getTop().getStop_button().setText(text);
//    }
}
