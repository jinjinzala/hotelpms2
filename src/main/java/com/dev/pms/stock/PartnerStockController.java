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
        businessNumber = "2978600442";
        List<PartnerStockVO> list = partnerStockService.getStockList(businessNumber);
        log.error("::::::stcok:{}:::::",list.get(0).getPartnerVOS().get(0).getCompanyName());
        mv.addObject("list",list);
        mv.setViewName("stock/partnerStockList");
        return mv;
    }

    @GetMapping("allItemsList")
    public ModelAndView getAllItemsList() throws Exception {
    ModelAndView mv = new ModelAndView();
    List<PartnerStockVO> list =  partnerStockService.getAllItemsList();
    mv.addObject("list",list);
    mv.setViewName("stock/AllItemsList");

    return mv;
    }


//    // 이벤트 핸들러 메서드
//    public void onCheckboxSelected() {
//        // 선택한 행 데이터를 저장할 List
//        List<MyVO> selectedRows = new ArrayList<>();
//
//        // 테이블에서 선택한 체크박스들을 가져온다 (checkboxes는 체크박스들의 리스트라고 가정)
//        for (CheckBox checkbox : checkboxes) {
//            if (checkbox.isSelected()) {
//                // 체크박스가 선택된 경우, 해당 행의 데이터를 MyVO에 저장하고 List에 추가한다.
//                MyVO row = new MyVO();
//                row.setColumn1(getValueFromTableColumn1(checkbox));  // 테이블의 열에서 값 가져오는 방법에 따라 변경
//                row.setColumn2(getValueFromTableColumn2(checkbox));  // 테이블의 열에서 값 가져오는 방법에 따라 변경
//                // 추가 필요한 열이 있다면 여기에 추가
//                selectedRows.add(row);
//            }
//        }
//
//        // List에 저장된 데이터를 INSERT 작업에 활용한다
//        for (MyVO row : selectedRows) {
//            // INSERT 작업 수행 (여기에 INSERT 코드 작성)
//            // row 객체의 데이터를 INSERT 쿼리에 활용하여 데이터베이스에 저장한다.
//        }
//    }
}