package com.dev.pms.stock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/partnerStock/*")
public class PartnerStockController {

    @Autowired
    private PartnerStockService partnerStockService;

    @GetMapping("stockList")
    public ModelAndView getStockList(String businessNumber) throws Exception {
        ModelAndView mv = new ModelAndView();
        businessNumber = "2978600442";
        List<PartnerStockVO> list = partnerStockService.getStockList(businessNumber);
        log.error("::::::stcok:{}:::::", list.get(0).getPartnerVOS().get(0).getCompanyName());
        mv.addObject("list", list);
        mv.setViewName("stock/partnerStockList");
        return mv;
    }

    @GetMapping("allItemsList")
    public ModelAndView getAllItemsList() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<PartnerStockVO> list = partnerStockService.getAllItemsList();
        mv.addObject("list", list);
        mv.setViewName("stock/AllItemsList");

        return mv;
    }
//
//    @PostMapping("/ItemNumberList")
//    public void update(String[] itemList) throws Exception {
//        System.out.println(itemList);
//        for (String value : itemList) {
//            // 서비스로 값을 전달
//            partnerStockService.setPartnerStock(value);
//        }
//    }

//    @PostMapping("/ItemNumberList")
//    public void update(@RequestBody Map<String, Object> requestData) throws Exception {
//        List<String> itemList = (List<String>) requestData.get("itemList");
//        System.out.println(itemList);
//        for (String value : itemList) {
//            // value를 서비스에 전달
//            partnerStockService.setPartnerStock(value);
//        }
//    }


    //다중 선택시 실행되는 컨트롤러
    @PostMapping("/ItemNumberList")
    public void update(@RequestBody Map<String, Object> requestData) throws Exception {
        List<String> itemList = (List<String>) requestData.get("itemList");
        System.out.println(itemList);
        for (String value : itemList) {
            System.out.println(value);
            // value를 서비스에 전달
            partnerStockService.setUpdateitemList(value);
            partnerStockService.setMultipleHotelInventory(value);
        }
    }

    // 1개 값만 선택시 최소수량 입력 후 인서트
    @PostMapping("/itemOrderQuantity")
    public void updateOrderQuantity(@RequestBody Map<String, Object> requestData) throws Exception {
        //배열로 들어온 아이템 넘버의 대괄호를 제거
        String itemList = requestData.get("itemList").toString();
        itemList = itemList.replace("[", "").replace("]", "");
        int itemValue = Integer.parseInt(itemList);

        String orderQuantity = requestData.get("orderQuantity").toString();
        System.out.println("컨트롤러의 아이템 리스트의 값"+ itemList);
        System.out.println("컨트롤러의 최소수량의 값" +orderQuantity);
        partnerStockService.setUpdateitemList(itemList);

    }
}
