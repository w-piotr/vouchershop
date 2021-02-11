package pl.pwojaczek.vouchershop.sales;

import pl.pwojaczek.vouchershop.catalog.ProductCatalog;
import pl.pwojaczek.vouchershop.catalog.ProductCatalogConfiguration;
import pl.pwojaczek.vouchershop.sales.basket.InMemoryBasketStorage;
import pl.pwojaczek.vouchershop.sales.offering.OfferMaker;

import java.math.BigDecimal;
import java.util.UUID;

public class SalesTestCase {
    protected InMemoryBasketStorage inMemoryBasketStorage;
    protected CurrentCustomerContext userContext;
    protected String customerId;
    protected ProductCatalog productCatalog;
    protected OfferMaker offerMaker;
    protected PaymentGateway paymentGateway;

    protected static ProductCatalog thereIsProductCatalog() {
        return new ProductCatalogConfiguration().myProductCatalog();
    }

    protected String thereIsCustomerWhoIsDoingSomeShoping() {
        var id = UUID.randomUUID().toString();
        this.customerId = id;
        return id;
    }

    protected String thereIsProductAvailable() {
        String productId = productCatalog.registerProduct();
        productCatalog.applyPrice(productId, BigDecimal.valueOf(20.20));
        productCatalog.updateDetails(productId, "info", "pic");

        return productId;
    }

    protected SalesFacade thereIsSalesModule() {
        return new SalesFacade(userContext, inMemoryBasketStorage, productCatalog, offerMaker, paymentGateway);
    }
}
