package com.dev.pms.clean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CleanService {


    @Autowired
    private CleanDAO cleanDAO;

    public List<CalenderVO>getCleanList(CalenderVO calenderVO)throws Exception{
        return cleanDAO.getCleanList(calenderVO);
    }

    public int insertSchedule(CalenderVO calenderVO)throws Exception{
        return cleanDAO.insertSchedule(calenderVO);
    }
    public int deleteSchedule(CalenderVO calenderVO)throws Exception{
        System.out.println(calenderVO.getScheduleNumber());
        return cleanDAO.deleteSchedule(calenderVO);
    }
}
