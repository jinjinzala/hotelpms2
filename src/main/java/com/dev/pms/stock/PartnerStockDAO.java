package com.dev.pms.stock;

import com.dev.pms.room.BookingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartnerStockDAO {
    public int setPartnerStock(PartnerStockVO partnerStockVO) throws Exception;

    public List<PartnerStockVO> getStockList(String businessNumber) throws  Exception;

    public List<PartnerStockVO> getAllItemsList() throws  Exception;

    //public int setItemStatus(PartnerStockVO partnerStockVO) throws  Exception;

    public int setUpdateitemList(int itemId) throws  Exception;
    public int setMultipleHotelInventory(int itemId) throws  Exception;
}
