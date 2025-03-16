package view.mainPanelsCreator.mainPanels.top;

import javax.swing.*;
import java.awt.*;

public class TopPanelController {

    public JPanel TOP_PANEL;

    private JButton SPEED_BUTTON, STOP_BUTTON;

    private Label POINTS_LABEL;

    private JLabel timeLabel;

    public TopPanelController(JButton SPEED_BUTTON, JButton stopButton, JLabel timeLabel) {
        this.SPEED_BUTTON = SPEED_BUTTON;
        this.STOP_BUTTON = stopButton;
        this.timeLabel = timeLabel;
    }

    public JPanel addTime() {
        TOP_PANEL = new JPanel(new GridLayout(1, 4));
        JPanel time_buttons = getTimeButtons();
        JPanel points = new JPanel(new GridLayout(2, 1));

        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setText("00:00 01.01.2000");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        POINTS_LABEL = new Label("0", Label.CENTER);
        POINTS_LABEL.setFont(new Font("Arial", Font.BOLD, 28));
        points.add(POINTS_LABEL);

        Label bottomLabel = new Label("PUNKTY", Label.CENTER);
        bottomLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        points.add(bottomLabel);

        TOP_PANEL.add(timeLabel);
        TOP_PANEL.add(time_buttons);
        TOP_PANEL.add(points);

        return TOP_PANEL;
    }



    private JPanel getTimeButtons() {
        JPanel time_buttons = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 30));
        SPEED_BUTTON.setPreferredSize(new Dimension(80, 40));
        STOP_BUTTON.setPreferredSize(new Dimension(80, 40));

        time_buttons.add(SPEED_BUTTON);
        time_buttons.add(STOP_BUTTON);
        time_buttons.setOpaque(true);

        return time_buttons;
    }
}
