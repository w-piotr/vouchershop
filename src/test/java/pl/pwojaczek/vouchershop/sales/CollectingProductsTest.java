package pl.pwojaczek.vouchershop.sales;

import org.junit.Before;
import org.junit.Test;
import pl.pwojaczek.vouchershop.sales.basket.Basket;
import pl.pwojaczek.vouchershop.sales.basket.InMemoryBasketStorage;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class CollectingProductsTest extends SalesTestCase {

    @Before
    public void setUp(){
        this.inMemoryBasketStorage = new InMemoryBasketStorage();
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

    private void thereIsXProductsInCustomerBasket(int productsCount, String customerId) {
        Basket basket = inMemoryBasketStorage.getBasket(customerId)
                .orElse(Basket.empty());

        assertThat(basket.getProductsCount()).isEqualTo(productsCount);
    }

}
