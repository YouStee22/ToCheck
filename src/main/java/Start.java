import controller.MainController;
import logic.simulator.GameSimulation;
import model.Countries;
import view.mainPanelsCreator.mainPanels.top.TimeObserver;
import view.MainView;

public class Start {

    public static void main(String[] args) {
        Countries countries = new Countries();
        MainView view = new MainView(countries.getCountries());
        TimeObserver timeObserver = new TimeObserver();

        GameSimulation gameSimulation = new GameSimulation(timeObserver, countries.getCountriesLength());
        new MainController(view, gameSimulation);

        timeObserver.addObserver(view);
    }
}
