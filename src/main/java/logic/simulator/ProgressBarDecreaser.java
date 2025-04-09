package logic.simulator;

import java.util.Random;

public class ProgressBarDecreaser {

    public int countryChooser(int lengthOfCountries) {
        Random random = new Random();

        return random.nextInt(6);
    }
}
