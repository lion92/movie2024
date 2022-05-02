package interfaces;

public interface DetailInterface {
    String footerCostDetail(double cost);
    String detailRental(String titreMovie,double cost );
    String footerFidelityDetail(int fidelity);
    StringBuilder headerDetail(String user);
}
