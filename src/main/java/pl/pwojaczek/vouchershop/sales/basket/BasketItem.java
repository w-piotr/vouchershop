package pl.pwojaczek.vouchershop.sales.basket;

public class BasketItem {
    final private String productId;
    final private Integer quantity;

    public BasketItem(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
