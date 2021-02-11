package pl.pwojaczek.vouchershop.sales.offering;

public interface PricingProvider {
    ProductPricing getForProduct(String productId);
}
