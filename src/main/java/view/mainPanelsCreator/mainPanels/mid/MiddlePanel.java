package view.mainPanelsCreator.mainPanels.mid;

import designPatterns.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MiddlePanel extends JPanel implements Observer<Integer> {

    private List<Observer<Integer>> progressBarObservers;

    public MiddlePanel(String[] countries) {
        progressBarObservers = new ArrayList<>();
        setLayout(new GridLayout(3, 2, 5, 5));

        for (String country : countries) {
            add(createProgressComponent(country));
        }
    }

    @Override
    public void update(Integer index) {
        if (index >= 0 && index < progressBarObservers.size()) {
            progressBarObservers.get(index).update(null);
        }
    }

    private JPanel createProgressComponent(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        JProgressBar progressBar = new JProgressBar();

        ProgressObserver observer = new ProgressObserver(progressBar);
        progressBarObservers.add(observer);

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
