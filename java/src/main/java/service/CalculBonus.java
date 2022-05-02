package service;

import movierental.Movie;
import movierental.Rental;

public class CalculBonus {
    public CalculBonus() {
    }

    public int calculBonus(Rental each, int thisBonus) {
        thisBonus = thisBonus + 1;
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
            thisBonus++;

        return thisBonus;
    }
}
