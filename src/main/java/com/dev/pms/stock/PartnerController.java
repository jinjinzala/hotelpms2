package com.dev.pms.stock;



import com.dev.pms.room.ReservedVO;
import com.dev.pms.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;

@Controller
@RequestMapping("/partner/*")
@Slf4j
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    // 사업자 등록 페이지
    @GetMapping("join")
    public ModelAndView setJoin(PartnerVO partnerVO) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("stock/Partnerregistration");
        return mv;
    }

    //사업자 정보를 DB에 인서트
    @PostMapping("join")
    public ModelAndView setPartner(PartnerVO partnerVO) throws Exception{
        ModelAndView mv = new ModelAndView();
        int result = partnerService.setPartner(partnerVO);;
       // mv.setViewName("common/ajaxResult");
        //mv.addObject("modalMessage", "등록 요청이 완료되었습니다. 관리자가 확인 후 승인 프로세스가 완료되면 사용자 로그인이 가능함을 유의해주세요.");
        mv.setViewName("redirect:/") ;
        return mv;
    }

    //사업자등록번호가 DB에 존재하는지 확인하는 기능
    @PostMapping ("/findBusinessNumber")
    public ResponseEntity<String> findBusinessNumber(String businessNumber) throws Exception {
        boolean isMatch = partnerService.getBusinessNumber(businessNumber);
        System.out.println(isMatch);
        if (isMatch) {
            return ResponseEntity.ok("use");
        } else {
            return ResponseEntity.ok("nouse");
        }
    }





}
