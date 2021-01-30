package pl.pwojaczek.vouchershop.catalog;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import static org.assertj.core.api.Assertions.*;

public class ListProductStorageTest {
    @Test
    public void itAllowAddProduct() {
        Product product = new Product(UUID.randomUUID());
        HashMapProductStorage productStorage = new HashMapProductStorage();
        productStorage.save(product);
        Assert.assertTrue(productStorage.isExists(product.getId()));
        Assert.assertFalse(productStorage.isExists("NOT_EXISTING_ID"));
    }
        
    @Test
    public void itAllowLoadAllProducts(){
        Product product1 = new Product(UUID.randomUUID());
        Product product2 = new Product(UUID.randomUUID());
        HashMapProductStorage productStorage = new HashMapProductStorage();
        productStorage.save(product1);
        productStorage.save(product2);

        HashMap<String, Product> products = new HashMap<>();
        products.put(product1.getId(),product1);
        products.put(product2.getId(),product2);

        Assert.assertEquals(productStorage.allProducts(), new ArrayList<>(products.values()));
    }

    @Test
    public void itAllowCheckIfProductExists(){
        Product product = new Product(UUID.randomUUID());
        HashMapProductStorage productStorage = new HashMapProductStorage();
        productStorage.save(product);

        Assert.assertTrue(productStorage.isExists(product.getId()));
        Assert.assertFalse(productStorage.isExists("NOT_EXISTING_ID"));
    }

    @Test
    public void testIt(){
        assertThat("Ala ma kota").containsIgnoringCase("ala");
    }
}
