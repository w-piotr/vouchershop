package pl.pwojaczek.vouchershop.sales;

public class AlwaysTheSameCustomerContext implements CurrentCustomerContext {
    @Override
    public String getCustomerId(){
        return "customer";
    }
}
