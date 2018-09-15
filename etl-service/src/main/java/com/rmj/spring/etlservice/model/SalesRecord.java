package com.rmj.spring.etlservice.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SalesRecord {

    private String    Region;
    private String    Country;
    private String   ItemType;
    private String  SalesChannel;
    private String  OrderPriority;
    private String   OrderDate;
    @Id
    private Double   OrderID;
    private String   ShipDate;
    private Integer   UnitsSold;
    private Double   UnitPrice;
    private Double   UnitCost;
    private Double  TotalRevenue;
    private Double  TotalCost;
    private Double  TotalProfit;

    public SalesRecord() {
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public String getSalesChannel() {
        return SalesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        SalesChannel = salesChannel;
    }

    public String getOrderPriority() {
        return OrderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        OrderPriority = orderPriority;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public Double getOrderID() {
        return OrderID;
    }

    public void setOrderID(Double orderID) {
        OrderID = orderID;
    }

    public String getShipDate() {
        return ShipDate;
    }

    public void setShipDate(String shipDate) {
        ShipDate = shipDate;
    }

    public Integer getUnitsSold() {
        return UnitsSold;
    }

    public void setUnitsSold(Integer unitsSold) {
        UnitsSold = unitsSold;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public Double getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(Double unitCost) {
        UnitCost = unitCost;
    }

    public Double getTotalRevenue() {
        return TotalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        TotalRevenue = totalRevenue;
    }

    public Double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(Double totalCost) {
        TotalCost = totalCost;
    }

    public Double getTotalProfit() {
        return TotalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        TotalProfit = totalProfit;
    }
}
