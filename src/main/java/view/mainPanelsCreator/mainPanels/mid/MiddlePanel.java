package view.mainPanelsCreator.mainPanels.mid;

import designPatterns.Observer;
import models.ProgressObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MiddlePanel extends JPanel {

    private String[] countires;

    private List<Observer<Integer>> observers;

    public MiddlePanel() {
        countires = new String[]{"Poland", "UK", "Germany", "Austria", "Russia", "Ukraine"};
        observers = new ArrayList<>();
        setLayout(new GridLayout(3, 2, 5, 5)); // 6 rows, 1 column with spacing

        for (int i = 0; i < countires.length; i++) {
            add(createProgressComponent(countires[i]));
        }
    }

    public void updateProgress(int index) {                                       //No mistrzostwo :>>>>
        if (index >= 0 && index < observers.size()) {
            observers.get(index).update(null);
        }
    }

    private JPanel createProgressComponent(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        JProgressBar progressBar = new JProgressBar();

        ProgressObserver observer = new ProgressObserver(progressBar);                      //Dodanie do wzroca
        observers.add(observer);

        progressBar.setValue(100);
        progressBar.setStringPainted(true);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        progressBar.setPreferredSize(new Dimension(200, 20));

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(progressBar);
        return panel;
    }
}
