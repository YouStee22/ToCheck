package controller;

import logic.threadController.ThreadsController;
import view.MainView;

public class Start {
    public static void main(String[] args) {
        MainView view = new MainView();
        DateModel dateModel = new DateModel();

        ThreadsController threadsController = new ThreadsController(dateModel);
        new MainController(view, threadsController);

        dateModel.addObserver(view);

    }
}
