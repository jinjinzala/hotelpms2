package com.dev.pms.stock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Random;
import static org.junit.Assert.*;
@SpringBootTest
class PartnerStockDAOTest {
    @Autowired
    private PartnerStockDAO partnerStockDAO;

    @Test
    void testInsertDummyData() throws Exception {
        String businessNumber = "2978600442";
        String productName = "칫솔";
        String[] itemCodes = generateItemCodes(80);
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String remarks1 = " 지속 가능한 원료를 사용해 제작한 친환경 칫솔입니다.";
        String remarks2 = "내구성이 뛰어나고, 편안한 그립감을 제공합니다. 또한, 100% 생분해 가능하여 친환경적입니다.";

        int result = 0;
        for (int i = 0; i < 50; i++) {
            PartnerStockVO partnerStock = new PartnerStockVO();
            partnerStock.setBusinessNumber(businessNumber);
            partnerStock.setProductName(productName);
            partnerStock.setItemCode(itemCodes[i]);
            partnerStock.setUnit((long) getRandomUnit());
            partnerStock.setUnitPrice(getUnitPriceByUnit(Math.toIntExact(partnerStock.getUnit())));
            partnerStock.setRemarks((i % 2 == 0) ? remarks1 : remarks2);
            partnerStock.setItemUsagestatus(false);
            result = partnerStockDAO.setPartnerStock(partnerStock);
        }

        // Assertion
        assertEquals(50, result);
    }

    private String[] generateItemCodes(int count) {
        String[] itemCodes = new String[count];
        String prefix = "C";
        for (int i = 0; i < count; i++) {
            String suffix = String.format("%03d", i + 1);
            itemCodes[i] = prefix + suffix;
        }
        return itemCodes;
    }

    private int getRandomUnit() {
        Random random = new Random();
        int unit = random.nextInt(6) + 5;  // 5 ~ 10 중에서 랜덤 선택
        return unit * 10;  // 10 단위로 조정
    }

    private Long getUnitPriceByUnit(int unit) {
        return unit * 1000L;
    }
}
