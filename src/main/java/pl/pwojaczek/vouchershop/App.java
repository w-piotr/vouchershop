package pl.pwojaczek.vouchershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pwojaczek.vouchershop.catalog.HashMapProductStorage;
import pl.pwojaczek.vouchershop.catalog.JdbcProductStorage;
import pl.pwojaczek.vouchershop.catalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}
