package pl.pwojaczek.vouchershop.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

@Configuration
public class ProductCatalogConfiguration {

    ProductCatalog myProductCatalog(){
        return new ProductCatalog(new HashMapProductStorage());
    }

    @Bean
    ProductStorage listProductStorage(){
        return new ListProductStorage();
    }

    @Bean
    ProductCatalog myFixtureAwareCatalog(ProductStorage productStorage){
        ProductCatalog productCatalog = new ProductCatalog(productStorage);
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
