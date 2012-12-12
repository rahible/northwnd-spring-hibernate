package com.aaronhible.model.views;
// Generated Dec 12, 2012 8:51:28 AM by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * SummaryOfSalesByQuarterId generated by hbm2java
 */
public class SummaryOfSalesByQuarterId  implements java.io.Serializable {


     private Date shippedDate;
     private int orderId;
     private BigDecimal subtotal;

    public SummaryOfSalesByQuarterId() {
    }

    public SummaryOfSalesByQuarterId(Date shippedDate, int orderId, BigDecimal subtotal) {
       this.shippedDate = shippedDate;
       this.orderId = orderId;
       this.subtotal = subtotal;
    }
   
    public Date getShippedDate() {
        return this.shippedDate;
    }
    
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
    public int getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public BigDecimal getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }




}

