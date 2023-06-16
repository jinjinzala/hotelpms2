package com.dev.pms.stock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/partnerStock/*")
public class PartnerStockController {

    @Autowired
    private PartnerStockService partnerStockService;

    @GetMapping("stockList")
    public ModelAndView getStockList(String businessNumber) throws Exception {
        ModelAndView mv = new ModelAndView();
        businessNumber = "70101010321";
        List<PartnerStockVO> list = partnerStockService.getStockList(businessNumber);
        log.error("::::::stcok:{}:::::",list.get(0).getPartnerVOS().get(0).getCompanyName());
        mv.addObject("list",list);
        mv.setViewName("stock/partnerStockList");

        System.out.printf("asdf");
        return mv;
    }
}
