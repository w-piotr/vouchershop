package pl.pwojaczek.vouchershop.catalog;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {

    public static final String NOT_EXISTS_ID = "notExistsId";
    public static final String PRODUCT_DESCRIPTION = "My nice product";
    public static final String PRODUCT_PICTURE = "https://nice_picture";

    @Test
    public void itAllowsToRegisterNewProduct(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.registerProduct();

        Assert.assertTrue(catalog.isExists(productId));
        Assert.assertFalse(catalog.isExists(NOT_EXISTS_ID));
    }

    @Test
    public void itAllowsLoadCreatedProduct(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.registerProduct();
        Product loaded = catalog.load(productId);

        Assert.assertEquals(loaded.getId(),productId);
    }

    @Test
    public void itAllowsFillDetails() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.registerProduct();
        catalog.updateDetails(productId, PRODUCT_DESCRIPTION, PRODUCT_PICTURE);
        Product loaded = catalog.load(productId);

        Assert.assertEquals(loaded.getPicture(), PRODUCT_PICTURE);
        Assert.assertEquals(loaded.getDescription(), PRODUCT_DESCRIPTION);
    }

    @Test
    public void itAllowsApplyPrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.registerProduct();
        catalog.applyPrice(productId, BigDecimal.TEN);
        Product loaded = catalog.load(productId);

        Assert.assertEquals(loaded.getPrice(), BigDecimal.TEN);
    }

    @Test
    public void itAllowsToListAllProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.registerProduct();
        catalog.updateDetails(productId, PRODUCT_DESCRIPTION, PRODUCT_PICTURE);
        catalog.applyPrice(productId, BigDecimal.TEN);

        String draftProductId = catalog.registerProduct();
        List<Product> all = catalog.allPublished();

        Assert.assertEquals(1,all.size());
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }
}
