package pl.pwojaczek.vouchershop.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListProductStorage implements ProductStorage {
    private final List<Product> products;

    public ListProductStorage() {
        this.products = new ArrayList<>();
    }

    @Override
    public void save(Product newProduct)
    {
        products.add(newProduct);
    }

    @Override
    public boolean isExists(String productId)
    {
        return products.stream().anyMatch(p->p.getId().equals(productId));
    }

    @Override
    public Optional<Product> load(String productId) {
        return products
                .stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();
    }

    @Override
    public List<Product> allProducts() {
    }
}
