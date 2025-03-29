package view.mainPanelsCreator.mainPanels;

import javax.swing.*;
import java.awt.*;

public class MainPanelController {

    private JFrame jFrame;
    private JPanel topPanel, centerPanel, bottomPanel;

    public MainPanelController(JFrame jFrame) {
        this.jFrame = jFrame;
        setupPanels();
    }

    private JPanel createPanel(Color color, int height) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(100, height));

        return panel;
    }

    private void setupPanels() {
        topPanel = createPanel(Color.RED, 100);
        centerPanel = createPanel(Color.GREEN, 700);
        bottomPanel = createPanel(Color.BLUE, 100);

        jFrame.add(topPanel, BorderLayout.NORTH);
        jFrame.add(centerPanel, BorderLayout.CENTER);
        jFrame.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void setTopPanel(JPanel newTopPanel) {
        topPanel.removeAll();
        topPanel.add(newTopPanel, BorderLayout.CENTER);
        topPanel.revalidate();
        topPanel.repaint();
    }

    public void setMiddleGrid(JPanel middleGridPanel) {
        centerPanel.removeAll();
        centerPanel.add(middleGridPanel, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

}
