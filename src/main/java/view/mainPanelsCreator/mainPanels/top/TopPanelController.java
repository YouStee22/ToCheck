package view.mainPanelsCreator.mainPanels.top;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopPanelController {

    public JPanel top_panel;

    private JButton speed_button;

    private JButton stop_button;

    private Label points_label;

    private JLabel timeLabel;

    public TopPanelController(JLabel timeLabel) {
        this.timeLabel = timeLabel;
        stop_button = new JButton("PLAY");
        speed_button = new JButton("X1");
    }

    public JPanel addTime() {
        top_panel = new JPanel(new GridLayout(1, 4));
        JPanel time_buttons = getTimeButtons();
        JPanel points = new JPanel(new GridLayout(2, 1));

        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setText("00:00 01.01.2000");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        points_label = new Label("0", Label.CENTER);
        points_label.setFont(new Font("Arial", Font.BOLD, 28));
        points.add(points_label);

        Label bottomLabel = new Label("PUNKTY", Label.CENTER);
        bottomLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        points.add(bottomLabel);

        top_panel.add(timeLabel);
        top_panel.add(time_buttons);
        top_panel.add(points);

        return top_panel;
    }

    private JPanel getTimeButtons() {
        JPanel time_buttons = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 30));
        speed_button.setPreferredSize(new Dimension(80, 40));
        stop_button.setPreferredSize(new Dimension(80, 40));

        time_buttons.add(speed_button);
        time_buttons.add(stop_button);
        time_buttons.setOpaque(true);

        return time_buttons;
    }

    public void addSpeedButtonListener(ActionListener listener) {
        speed_button.addActionListener(listener);
    }

    public void setPlayButton() {
        stop_button.setText(stop_button.getText().equals("PLAY") ? "PAUSE" : "PLAY");                           //operator trójargumentowy
    }


    public void addPauseButtonListener(ActionListener listener) {
        stop_button.addActionListener(listener);
    }

    public void increaseSpeedButton(String text) {
        speed_button.setText(text);
    }
}
