package service;

import movierental.Movie;
import movierental.Rental;

public class CalculPrice {
    public CalculPrice() {
    }

    public double findPrice(Rental each) {
        double thisAmount=0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
    public int calculBonus(Rental each,int thisBonus){
        thisBonus=thisBonus+1;
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
            thisBonus++;

        return thisBonus;
    }
}
