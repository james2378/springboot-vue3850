package com.project.demo.controller;

import com.project.demo.entity.CompetitionRegistration;
import com.project.demo.service.CompetitionRegistrationService;
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
 *比赛报名：(CompetitionRegistration)表控制层
 *
 */
@RestController
@RequestMapping("/competition_registration")
public class CompetitionRegistrationController extends BaseController<CompetitionRegistration,CompetitionRegistrationService> {

    /**
     *比赛报名对象
     */
    @Autowired
    public CompetitionRegistrationController(CompetitionRegistrationService service) {
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
