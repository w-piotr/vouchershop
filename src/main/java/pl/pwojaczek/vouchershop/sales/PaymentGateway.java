package pl.pwojaczek.vouchershop.sales;

interface PaymentGateway {
    PaymentDetails registerFor(Reservation reservation, ClientData clientData);
}
