package com.project.demo.controller;

import com.project.demo.entity.Athletes;
import com.project.demo.service.AthletesService;
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
 *运动员：(Athletes)表控制层
 *
 */
@RestController
@RequestMapping("/athletes")
public class AthletesController extends BaseController<Athletes,AthletesService> {

    /**
     *运动员对象
     */
    @Autowired
    public AthletesController(AthletesService service) {
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
