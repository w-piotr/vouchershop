package pl.pwojaczek.vouchershop.sales;

import org.junit.Before;
import org.junit.Test;
import pl.pwojaczek.vouchershop.catalog.ProductCatalog;
import pl.pwojaczek.vouchershop.catalog.ProductCatalogConfiguration;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class CollectingProductsTest {

    private BasketStorage basketStorage;
    private CurrentSystemUserContext userContext;
    private String customerId;
    private ProductCatalog productCatalog;

    @Before
    public void setUp(){
        this.basketStorage = new BasketStorage();
        this.customerId = UUID.randomUUID().toString();
        this.userContext = () -> customerId;
        this.productCatalog = thereIsProductCatalog();
    }

    @Test
    public void itAllowAddProductToBasket() {
        SalesFacade salesModule = thereIsSalesModule();
        String productId = thereIsProductAvailable();
        String customerId = thereIsCustomerWhoIsDoingSomeShoping();

        salesModule.addToBasket(productId);

        thereIsXProductsInCustomerBasket(1, customerId);
    }

    private String thereIsCustomerWhoIsDoingSomeShoping() {
        var id = UUID.randomUUID().toString();
        this.customerId = id;
        return id;
    }

    private String thereIsProductAvailable() {
        String productId = productCatalog.registerProduct();
        productCatalog.applyPrice(productId, BigDecimal.valueOf(20.20));
        productCatalog.updateDetails(productId, "info", "pic");

        return productId;
    }

    private SalesFacade thereIsSalesModule() {
        return new SalesFacade(userContext, basketStorage, productCatalog);
    }

    private void thereIsXProductsInCustomerBasket(int productsCount, String customerId) {
        Basket basket = basketStorage.getBasket(customerId)
                .orElse(Basket.empty());

        assertThat(basket.getProductsCount()).isEqualTo(productsCount);
    }

    private static ProductCatalog thereIsProductCatalog() {
        return new ProductCatalogConfiguration().myProductCatalog();
    }
}
