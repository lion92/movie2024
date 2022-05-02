package movierental;
import interfaces.DetailInterface;
import service.CalculImplementation;
import service.DetailImplementation;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private final List<Rental> _rentals = new ArrayList<>();

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
        DetailInterface rentalDetailManager=new DetailImplementation();
        double totalCost = 0;
        int fidelityPoint = 0;
        StringBuilder rentalDetail=rentalDetailManager.headerDetail(getName());
        CalculImplementation calculate=new CalculImplementation();
        for (Rental rental: _rentals) {
            double cost;
            cost=calculate.findPrice(rental);
            fidelityPoint=calculate.calculBonus(rental,fidelityPoint);
            rentalDetail.append(rentalDetailManager.detailRental(rental.getMovie().getTitle(), cost));
            totalCost=calculate.sum(totalCost, cost);
        }
        rentalDetail.append(rentalDetailManager.footerCostDetail(totalCost));
        rentalDetail.append(rentalDetailManager.footerFidelityDetail(fidelityPoint));

        return rentalDetail.toString();
    }
}
