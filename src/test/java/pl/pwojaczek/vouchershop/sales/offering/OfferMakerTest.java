package pl.pwojaczek.vouchershop.sales.offering;

import org.junit.Test;
import pl.pwojaczek.vouchershop.sales.basket.BasketItem;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class OfferMakerTest {

    @Test
    public void itCreateOfferBasedOnEmptyBasketItemsList(){
        List<BasketItem> items = Collections.emptyList();
        OfferMaker offerMaker = thereIsOfferMaker();

        Offer offer = offerMaker.calculate(items);

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
        assertThat(offer.getOfferItems()).hasSize(0);
    }

    @Test
    public void itCreateOfferBasedOnSingleItem(){
        List<BasketItem> items = thereIsSingleItemList();
        OfferMaker offerMaker = thereIsOfferMaker();
        Offer offer = offerMaker.calculate(items);
        assertThat(offer.getTotal()).isEqualTo(BigDecimal.valueOf(20.10));
    }

    @Test
    public void itCreateOfferBasedOnMultipleItemsList(){
        List<BasketItem> items = thereIsExampleItemsList();
        OfferMaker offerMaker = thereIsOfferMaker();

        Offer offer = offerMaker.calculate(items);
        assertThat(offer.getTotal()).isEqualTo(BigDecimal.valueOf(60.30));
    }

    private List<BasketItem> thereIsExampleItemsList() {
        return Arrays.asList(
                new BasketItem("prod1", 1),
                new BasketItem("prod2", 2)
        );
    }

    private List<BasketItem> thereIsSingleItemList() {
        return Collections.singletonList(
                new BasketItem("prod1", 1)
        );
    }

    private OfferMaker thereIsOfferMaker() {
        return new OfferMaker((productId) -> new ProductPricing(BigDecimal.valueOf(20.10), "some description"));
    }
}
