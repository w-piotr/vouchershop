package pl.pwojaczek.vouchershop.sales;

import pl.pwojaczek.vouchershop.catalog.Product;

import java.util.*;

public class Basket {
    private final Map<String, Product> products;

    public Basket(){
        this.products = new HashMap<>();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void add(Product product) {
        products.put(product.getId(), product);
    }

    public Integer getProductsCount() {
        return  products.size();
    }

    public List<BasketItem> getBasketItems() {
        return Collections.emptyList();
    }

    public void remove(String id) {
        products.remove(id);
    }
}
