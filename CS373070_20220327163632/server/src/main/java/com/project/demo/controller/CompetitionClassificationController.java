package com.project.demo.controller;

import com.project.demo.entity.CompetitionClassification;
import com.project.demo.service.CompetitionClassificationService;
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
 *比赛分类：(CompetitionClassification)表控制层
 *
 */
@RestController
@RequestMapping("/competition_classification")
public class CompetitionClassificationController extends BaseController<CompetitionClassification,CompetitionClassificationService> {

    /**
     *比赛分类对象
     */
    @Autowired
    public CompetitionClassificationController(CompetitionClassificationService service) {
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
