package pl.pwojaczek.vouchershop.catalog;

import java.math.BigDecimal;
import java.util.UUID;


public class Product {
    private final UUID productId;
    private String description;
    private String picture;
    private BigDecimal price;

    public Product(UUID productId) {
        this.productId = productId;
    }

    public String getId(){
        return productId.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
