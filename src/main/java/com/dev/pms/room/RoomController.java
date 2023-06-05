package com.dev.pms.room;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/room/*")
@Slf4j
public class RoomController {

    //URL 주소 변경해주기 테스트 URL room/rm
    @GetMapping ("rm")
    public ModelAndView room() throws  Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("room/roommanagement");
        return mv;

    }

}