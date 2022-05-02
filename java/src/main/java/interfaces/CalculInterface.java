package interfaces;

import movierental.Rental;

public interface CalculInterface {
    double findPrice(Rental each);
    double sum(double costPrecedent, double cost);
    int calculBonus(Rental each, int thisBonus);
}
