package com.dev.pms.stock;

import com.dev.pms.room.BookingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartnerStockDAO {
    public int setPartnerStock(PartnerStockVO partnerStockVO) throws Exception;

    public List<PartnerStockVO> getStockList(String businessNumber) throws  Exception;

    public List<PartnerStockVO> getAllItemsList() throws  Exception;
}
