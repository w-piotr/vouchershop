package pl.pwojaczek.vouchershop.sales;

public class PaymentDetails {
    private final String url;
    private final String paymentId;
    private final String reservationId;

    public PaymentDetails(String url, String paymentId, String reservationId){
        this.url = url;
        this.paymentId = paymentId;
        this.reservationId = reservationId;
    }

    public String getPaymantUrl() {
        return url;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getReservationId() {
        return reservationId;
    }
}
