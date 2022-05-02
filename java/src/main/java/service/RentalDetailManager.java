package service;

public class RentalDetailManager {


    public RentalDetailManager() {
    }

    public String detailRental(String titreMovie,double cost ){

        return "\t" + titreMovie + "\t" + String.valueOf(cost) + "\n";
    }
    public String footerDetail(double cost){

        return "Amount owed is " + String.valueOf(cost) + "\n";
    }
    public String footerDetail(int fidelity){

        return "You earned " + String.valueOf(fidelity) + " frequent renter points";
    }


}
