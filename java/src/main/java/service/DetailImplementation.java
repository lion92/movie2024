package service;

import interfaces.DetailInterface;

public class DetailImplementation implements DetailInterface {
    public String detailRental(String titreMovie,double cost ){

        return "\t" + titreMovie + "\t" + String.valueOf(cost) + "\n";
    }
    public String footerCostDetail(double cost){

        return "Amount owed is " + String.valueOf(cost) + "\n";
    }
    public String footerFidelityDetail(int fidelity){

        return "You earned " + String.valueOf(fidelity) + " frequent renter points";
    }

    public StringBuilder headerDetail(String user){
        StringBuilder rentalDetail = new StringBuilder("Rental Record for " + user + "\n");
        return rentalDetail;
    }
}

