package pl.pwojaczek.vouchershop.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pwojaczek.vouchershop.catalog.ProductCatalog;
import pl.pwojaczek.vouchershop.sales.basket.InMemoryBasketStorage;

import java.util.UUID;

@Configuration
public class SalesConfiguration {

    @Bean
    SalesFacade salesFacade(CurrentCustomerContext customerContext, ProductCatalog productCatalog){
        return new SalesFacade(customerContext, new InMemoryBasketStorage(), productCatalog);
    }

    @Bean
    CurrentCustomerContext customerContext(){
        return new RandomCustomerContext();
    }
}
