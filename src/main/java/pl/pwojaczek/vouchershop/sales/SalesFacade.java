package pl.pwojaczek.vouchershop.sales;

import pl.pwojaczek.vouchershop.catalog.Product;
import pl.pwojaczek.vouchershop.catalog.ProductCatalog;
import pl.pwojaczek.vouchershop.sales.basket.Basket;
import pl.pwojaczek.vouchershop.sales.basket.InMemoryBasketStorage;

public class SalesFacade {

    private final CurrentCustomerContext currentCustomerContext;
    private final InMemoryBasketStorage inMemoryBasketStorage;
    private final ProductCatalog productCatalog;

    public SalesFacade(CurrentCustomerContext currentCustomerContext, InMemoryBasketStorage inMemoryBasketStorage, ProductCatalog productCatalog) {
        this.currentCustomerContext = currentCustomerContext;
        this.inMemoryBasketStorage = inMemoryBasketStorage;
        this.productCatalog = productCatalog;
    }

    public void addToBasket(String productId) {
        Basket basket = inMemoryBasketStorage.getBasket(getCurrentCustomerId())
                .orElse(Basket.empty());

        Product product = productCatalog.load(productId);

        basket.add(product);

        inMemoryBasketStorage.addForCustomer(getCurrentCustomerId(), basket);
    }

    private String getCurrentCustomerId() {
        return currentCustomerContext.getCustomerId();
    }
}
