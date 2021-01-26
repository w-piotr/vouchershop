package pl.pwojaczek.vouchershop.catalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class CatalogController {
    private ProductCatalog catalog;

    public CatalogController(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    @GetMapping("/api/products")
    public List<Product> allProducts(){
        return catalog.allPublished();
    }
}
