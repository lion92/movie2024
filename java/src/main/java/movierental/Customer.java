package movierental;
import service.Calcul;
import service.RentalDetailManager;

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
        RentalDetailManager rentalDetailManager=new RentalDetailManager();
        double totalCost = 0;
        int fidelityPoint = 0;
        String rentalDetail = "Rental Record for " + getName() + "\n";
        Calcul calcul=new Calcul();
        for (Rental rental: _rentals) {
            double cost = 0;

            cost=calcul.findPrice(rental);
            //determine amounts for each line

            // add frequent renter points


            // add bonus for a two day new release rental
            fidelityPoint=calcul.calculBonus(rental,fidelityPoint);

            // show figures
            rentalDetail += rentalDetailManager.detailRental(rental.getMovie().getTitle(),cost);
            totalCost=calcul.sum(totalCost, cost);
        }

        // add footer lines"Amount owed is " + String.valueOf(totalAmount) + "\n";
        rentalDetail += rentalDetailManager.footerDetail(totalCost);
        rentalDetail += rentalDetailManager.footerDetail(fidelityPoint);

        return rentalDetail;
    }
}
