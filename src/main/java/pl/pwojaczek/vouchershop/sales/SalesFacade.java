package pl.pwojaczek.vouchershop.sales;

import pl.pwojaczek.vouchershop.catalog.Product;
import pl.pwojaczek.vouchershop.catalog.ProductCatalog;

public class SalesFacade {

    private final CurrentSystemUserContext currentSystemUserContext;
    private final BasketStorage basketStorage;
    private ProductCatalog productCatalog;

    public SalesFacade(CurrentSystemUserContext currentSystemUserContext, BasketStorage basketStorage, ProductCatalog productCatalog) {
        this.currentSystemUserContext = currentSystemUserContext;
        this.basketStorage = basketStorage;
        this.productCatalog = productCatalog;
    }

    public void addToBasket(String productId) {
        Basket basket = basketStorage.getBasket(getCurrentCustomerId())
                .orElse(Basket.empty());

        Product product = productCatalog.load(productId);

        basket.add(product);

        basketStorage.addForCustomer(getCurrentCustomerId(), basket);
    }

    private String getCurrentCustomerId() {
        return currentSystemUserContext.getCustomerId();
    }
}
