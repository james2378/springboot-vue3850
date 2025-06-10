package com.project.demo.controller;

import com.project.demo.entity.CompetitionResultInformation;
import com.project.demo.service.CompetitionResultInformationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *比赛成绩信息：(CompetitionResultInformation)表控制层
 *
 */
@RestController
@RequestMapping("/competition_result_information")
public class CompetitionResultInformationController extends BaseController<CompetitionResultInformation,CompetitionResultInformationService> {

    /**
     *比赛成绩信息对象
     */
    @Autowired
    public CompetitionResultInformationController(CompetitionResultInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
