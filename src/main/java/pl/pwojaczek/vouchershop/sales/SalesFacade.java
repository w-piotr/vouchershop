package pl.pwojaczek.vouchershop.sales;

import pl.pwojaczek.vouchershop.catalog.Product;
import pl.pwojaczek.vouchershop.catalog.ProductCatalog;
import pl.pwojaczek.vouchershop.sales.basket.Basket;
import pl.pwojaczek.vouchershop.sales.basket.InMemoryBasketStorage;
import pl.pwojaczek.vouchershop.sales.offering.Offer;
import pl.pwojaczek.vouchershop.sales.offering.OfferMaker;

public class SalesFacade {

    private final CurrentCustomerContext currentCustomerContext;
    private final InMemoryBasketStorage inMemoryBasketStorage;
    private final ProductCatalog productCatalog;
    private final OfferMaker offerMaker;

    public SalesFacade(CurrentCustomerContext currentCustomerContext, InMemoryBasketStorage inMemoryBasketStorage, ProductCatalog productCatalog, OfferMaker offerMaker) {
        this.currentCustomerContext = currentCustomerContext;
        this.inMemoryBasketStorage = inMemoryBasketStorage;
        this.productCatalog = productCatalog;
        this.offerMaker=offerMaker;
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

    public Offer getCurrentOffer() {
        Basket basket = inMemoryBasketStorage.getBasket(getCurrentCustomerId())
                .orElse(Basket.empty());

        return offerMaker.calculate(basket.getBasketItems());
    }

    public PaymentDetails acceptOffer() {
        return null;
    }
}
