package movierental;
import service.CalculPrice;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int fidelityPoint = 0;
        String result = "Rental Record for " + getName() + "\n";
        CalculPrice calculPrice=new CalculPrice();
        for (Rental movie: _rentals) {
            double thisAmount = 0;

            thisAmount=calculPrice.findPrice(movie);
            //determine amounts for each line

            // add frequent renter points


            // add bonus for a two day new release rental
            fidelityPoint=calculPrice.calculBonus(movie,fidelityPoint);

            // show figures for this rental
            result += "\t" + movie.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(fidelityPoint) + " frequent renter points";

        return result;
    }
}
