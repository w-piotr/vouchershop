package pl.pwojaczek.vouchershop.sales;

import org.junit.Before;
import org.junit.Test;
import pl.pwojaczek.vouchershop.sales.basket.InMemoryBasketStorage;
import pl.pwojaczek.vouchershop.sales.offering.Offer;
import pl.pwojaczek.vouchershop.sales.offering.OfferMaker;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderingTest extends SalesTestCase{
    @Before
    public void setUp(){
        this.inMemoryBasketStorage = new InMemoryBasketStorage();
        this.customerId = UUID.randomUUID().toString();
        this.userContext = () -> customerId;
        this.productCatalog = thereIsProductCatalog();
        this.offerMaker = thereIsOfferMaker();
    }

    private OfferMaker thereIsOfferMaker() {
        return new OfferMaker(new ProductCatalogPricingProvider(productCatalog));
    }

    @Test
    public void itCreateOfferBasedSelectedProducts(){
        SalesFacade salesModule = thereIsSalesModule();
        String productId = thereIsProductAvailable();
        String customerId = thereIsCustomerWhoIsDoingSomeShoping();

        salesModule.addToBasket(productId);
        salesModule.addToBasket(productId);

        Offer offer = salesModule.getCurrentOffer();

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.valueOf(40.40));
    }
}
