package pl.pwojaczek.vouchershop.sales.offering;

import pl.pwojaczek.vouchershop.catalog.Product;
import pl.pwojaczek.vouchershop.catalog.ProductCatalog;
import pl.pwojaczek.vouchershop.sales.offering.PricingProvider;
import pl.pwojaczek.vouchershop.sales.offering.ProductPricing;

public class ProductCatalogPricingProvider implements PricingProvider {
    private final ProductCatalog productCatalog;

    public ProductCatalogPricingProvider(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public ProductPricing getForProduct(String productId) {
        Product product = productCatalog.load(productId);
        return new ProductPricing(product.getPrice(), product.getDescription());
    }
}
