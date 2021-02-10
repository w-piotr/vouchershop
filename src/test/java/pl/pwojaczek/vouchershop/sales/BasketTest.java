package pl.pwojaczek.vouchershop.sales;

import org.junit.Test;
import pl.pwojaczek.vouchershop.catalog.Product;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class BasketTest {

    @Test
    public void newlyCreatedBasketIsEmpty() {
        Basket basket = new Basket();

        assertThat(basket.isEmpty())
                .isTrue();
    }

    @Test
    public void basketWithProductIsNotEmpty() {
        Basket basket = new Basket();
        Product product = thereIsProduct("item-1111");

        basket.add(product);

        assertThat(basket.isEmpty())
                .isFalse();
    }

    @Test
    public void itShowsProductsCount() {
        Basket basket = new Basket();
        var product1 = thereIsProduct("item-1111");
        var product2 = thereIsProduct("item-2222");

        basket.add(product1);
        basket.add(product2);

        assertThat(basket.getProductsCount())
                .isEqualTo(2);
    }

    @Test
    public void itShowSingleLineForSameProductAddedTwice() {
        Basket basket = new Basket();
        var product1 = thereIsProduct("item-1111");

        basket.add(product1);
        basket.add(product1);
        basket.add(product1);

        assertThat(basket.getProductsCount())
                .isEqualTo(1);
    }

    @Test
    public void itContainsBasketLineQuantity() {
        Basket basket = new Basket();
        var product1 = thereIsProduct("item-1111");
        var product2 = thereIsProduct("item-2222");

        basket.add(product1);
        basket.add(product1);
        basket.add(product1);
        basket.add(product2);

        basketContainsProductWithQuantity(basket, product1, 3);
        basketContainsProductWithQuantity(basket, product2, 1);
    }

    @Test
    public void itAllowsToRemoveProduct(){
        Basket basket = new Basket();
        var product1 = thereIsProduct("item-1111");

        basket.add(product1);
        basket.add(product1);
        basket.add(product1);

        basket.remove(product1.getId());
    }

    private void basketContainsProductWithQuantity(Basket basket, Product product, int expectedQuantity) {
        assertThat(basket.getBasketItems())
                .filteredOn(basketItem -> basketItem.getProductId().equals(product.getId()))
                .extracting(BasketItem::getQuantity)
                .first()
                .isEqualTo(expectedQuantity);
    }

    private Product thereIsProduct(String name) {
        Product product = new Product(UUID.randomUUID());
        product.setDescription(name);

        return product;
    }
}