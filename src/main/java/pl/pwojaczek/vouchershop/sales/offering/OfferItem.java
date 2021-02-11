package pl.pwojaczek.vouchershop.sales.offering;

import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

import java.math.BigDecimal;

public class OfferItem {
    private final String productId;
    private final Integer quantity;
    private final BigDecimal unitPrice;
    private final String description;

    public OfferItem(String productId, Integer quantity, BigDecimal unitPrice, String description) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getProductId(){
        return productId;
    }

    public String getDescription(){
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
