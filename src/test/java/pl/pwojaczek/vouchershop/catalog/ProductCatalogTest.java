package pl.pwojaczek.vouchershop.catalog;

import org.junit.Assert;
import org.junit.Test;

public class ProductCatalogTest {
    @Test
    public void itAllowsToRegisterNewProduct(){
        ProductCatalog catalog = therIsProductCatalog();
        String productId = catalog.registerProduct();
        Assert.assertTrue(catalog.isExists(productId));
    }
}
