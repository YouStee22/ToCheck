package logic.simulator;



import designPatterns.Observable;
import designPatterns.Observer;
import view.mainPanelsCreator.mainPanels.top.TimeObserver;

import javax.swing.*;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.util.*;


public class GameSimulation implements Observable {

    private final List<Observer<Integer>> observers = new ArrayList<>();

    private int TIME_SPEED = 1000, UPDATE_SPEED = 2000;

    private int countries;

    private Timer timer;

    private Calendar calendar;

    private Thread monitoringThread;

    private Date currentDate;

    private boolean isMonitoringActive;

    private TimeObserver timeObserver;

    private ProgressBarDecreaser decreaser;

    public GameSimulation(TimeObserver timeObserver, int countires) {
        this.countries = countires;
        this.timeObserver = timeObserver;
        calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        decreaser = new ProgressBarDecreaser();
    }

    public void executeTask() {
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                notifyObservers();
            }
        }, 0, 150);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Integer> observer : observers) {
            observer.update(decreaser.countryChooser(countries));
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void monitorCountries1() {
        while (isMonitoringActive) {
            try {
                Thread.sleep(UPDATE_SPEED);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                System.out.println("Błąd w odświeżaniu wątku");
                e.printStackTrace();
            }
        }
    }

    public  void updateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        if (TIME_SPEED > 1)
            getCalendar().add(Calendar.SECOND, 1);
        else if (TIME_SPEED == 1) {
            getCalendar().add(Calendar.MINUTE, 3);
        }
        currentDate = getCalendar().getTime();
        String dateTimeString = formatter.format(currentDate);

        timeObserver.setDate(dateTimeString);
    }

    public void toggleMonitoring() {                                 //toggle  - Włacz wyłącz
        if (!isMonitoringActive) {
            getTimer().start();
            isMonitoringActive = true;
            setTimeSpeedAndUpdate(1000, 2000);
            monitoringThread = new Thread(() -> monitorCountries1());
            monitoringThread.start();
        } else {
            isMonitoringActive = false;
            getTimer().start();
            setTimeSpeedAndUpdate(0,0);
            if (monitoringThread != null && monitoringThread.isAlive()) {
                monitoringThread.interrupt();
                try {
                    monitoringThread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread stopping interrupted.");
                }
            }
        }
        System.out.println(timer.isRunning());
    }

    public void setCalendar() {
        setTimer(new Timer(getTimeSpeed(), e -> updateTime()));
        getTimer().start();
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getTimeSpeed() {
        return TIME_SPEED;
    }

    public void setTimeSpeedAndUpdate(int timeSpeed, int update) {
        TIME_SPEED = timeSpeed;
        UPDATE_SPEED = update;
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
