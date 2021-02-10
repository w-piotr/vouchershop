package pl.pwojaczek.vouchershop.sales;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class BasketStorage {
    private final Map<String, Basket> baskets;

    public BasketStorage(){
        this.baskets = new ConcurrentHashMap<>();
    }

    public Optional<Basket> getBasket(String customerId) {
        return Optional.ofNullable(baskets.get(customerId));
    }

    public void addForCustomer(String currentCustomerId, Basket basket) {
        baskets.put(currentCustomerId, basket);
    }
}
