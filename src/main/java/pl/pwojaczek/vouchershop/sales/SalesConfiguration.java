package pl.pwojaczek.vouchershop.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pwojaczek.vouchershop.catalog.ProductCatalog;
import pl.pwojaczek.vouchershop.sales.basket.InMemoryBasketStorage;
import pl.pwojaczek.vouchershop.sales.offering.OfferMaker;
import pl.pwojaczek.vouchershop.sales.offering.ProductCatalogPricingProvider;

@Configuration
public class SalesConfiguration {

    @Bean
    SalesFacade salesFacade(CurrentCustomerContext customerContext, ProductCatalog productCatalog, OfferMaker offerMaker){
        return new SalesFacade(customerContext, new InMemoryBasketStorage(), productCatalog, offerMaker);
    }

    @Bean
    CurrentCustomerContext customerContext(){
        return new AlwaysTheSameCustomerContext();
    }

    @Bean
    OfferMaker offerMaker(ProductCatalog productCatalog){
        return new OfferMaker(new ProductCatalogPricingProvider(productCatalog));
    }
}
