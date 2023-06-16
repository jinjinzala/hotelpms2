package com.dev.pms.stock;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelStockVO {
    private Long inventoryId;
    private Long itemId;
    private Long currentStock;
    private Long autoOrderQuantity;
    private String orderStatus;
    private String roomUsageStatus;
    private String productName;
    private String itemCode;
    private Long unitPrice;

}
