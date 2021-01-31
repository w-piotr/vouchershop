package pl.pwojaczek.vouchershop.catalog.exceptions;

public class ProductCatalogException extends IllegalStateException {
    public ProductCatalogException(String message) {
        super(message);
    }
}