package models;

import designPatterns.Observer;

import javax.swing.*;

public class ProgressObserver implements Observer<Integer> {

    private JProgressBar progressBar;

    public ProgressObserver(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void update(Integer progress) {
        progressBar.setValue(progressBar.getValue() - 1);
    }
}
