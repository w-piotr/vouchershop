package pl.pwojaczek.vouchershop.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProductCatalogConfiguration {


    ProductCatalog myProductCatalog(){
        return new ProductCatalog();
    }

    @Bean
    ProductCatalog myFixtureAwareCatalog(){
        ProductCatalog productCatalog = new ProductCatalog();
        var p1 = productCatalog.registerProduct();
        productCatalog.applyPrice(p1, BigDecimal.valueOf(22.22));
        productCatalog.updateDetails(p1, "Nice product", "Nice Picture");

        var p2 = productCatalog.registerProduct();
        productCatalog.applyPrice(p2, BigDecimal.valueOf(33.33));
        productCatalog.updateDetails(p2, "Ugly product", "Ugly Picture");

        var p3 = productCatalog.registerProduct();
        productCatalog.applyPrice(p3, BigDecimal.valueOf(11.11));
        productCatalog.updateDetails(p3, "Product", "Picture");

        return productCatalog;
    }
}
