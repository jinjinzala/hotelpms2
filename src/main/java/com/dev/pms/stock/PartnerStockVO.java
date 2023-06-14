package com.dev.pms.stock;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
public class PartnerStockVO {
    private Long itemId;
    private String businessNumber;
    private String productName;
    private String itemCode;
    private Long unit;
    private Long unitPrice;
    private Date registrationDate;
    private String remarks;
    private Boolean itemUsagestatus;
    private  String companyName;
    private List<PartnerVO> partnerVOS;
}
