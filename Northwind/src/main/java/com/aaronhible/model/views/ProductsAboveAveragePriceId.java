package com.aaronhible.model.views;
// Generated Dec 12, 2012 8:51:28 AM by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;

/**
 * ProductsAboveAveragePriceId generated by hbm2java
 */
public class ProductsAboveAveragePriceId  implements java.io.Serializable {


     private String productName;
     private BigDecimal unitPrice;

    public ProductsAboveAveragePriceId() {
    }

    public ProductsAboveAveragePriceId(String productName, BigDecimal unitPrice) {
       this.productName = productName;
       this.unitPrice = unitPrice;
    }
   
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }




}

