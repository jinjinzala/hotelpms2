package com.dev.pms.stock;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PartnerService {

    @Autowired
    private PartnerDAO partnerDAO;

    public boolean getBusinessNumber(String businessNumber) throws Exception {
        PartnerVO partner = partnerDAO.getBusinessNumber(businessNumber);

        return partner != null; // partner가 null이면 일치하는 값이 없는 것으로 판단합니다.
    }

    public int setPartner(PartnerVO partnerVO) throws Exception {
        return  partnerDAO.setPartner(partnerVO);
    }

}
