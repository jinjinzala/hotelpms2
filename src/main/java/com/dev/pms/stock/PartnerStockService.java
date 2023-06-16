package com.dev.pms.stock;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PartnerStockService {

    @Autowired
    private PartnerStockDAO partnerStockDAO;


    public List<PartnerStockVO> getStockList(String businessNumber) throws Exception{
        return partnerStockDAO.getStockList(businessNumber);
    }

    public List<PartnerStockVO> getAllItemsList() throws Exception{
        return partnerStockDAO.getAllItemsList();
    }
    //    public int setItemStatus(PartnerStockVO partnerStockVO) throws Exception{
//        return partnerStockDAO.setItemStatus(partnerStockVO);
//    }
    public int setUpdateitemList(String value) throws Exception {
        int itemId = Integer.parseInt(value);
        //partnerStockVO.setItemId(itemId);
        return partnerStockDAO.setUpdateitemList(itemId);
        // 예: 데이터베이스에 저장, 외부 API 호출 등
    }

    public int setMultipleHotelInventory(String value) throws Exception {
        int itemId = Integer.parseInt(value);
        //partnerStockVO.setItemId(itemId);
        return partnerStockDAO.setMultipleHotelInventory(itemId);
        // 예: 데이터베이스에 저장, 외부 API 호출 등
    }

}
