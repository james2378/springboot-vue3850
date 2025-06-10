package com.project.demo.controller;

import com.project.demo.entity.SiteInformation;
import com.project.demo.service.SiteInformationService;
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
 *场地信息：(SiteInformation)表控制层
 *
 */
@RestController
@RequestMapping("/site_information")
public class SiteInformationController extends BaseController<SiteInformation,SiteInformationService> {

    /**
     *场地信息对象
     */
    @Autowired
    public SiteInformationController(SiteInformationService service) {
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
