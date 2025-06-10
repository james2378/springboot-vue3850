package com.project.demo.controller;

import com.project.demo.entity.RefereeAllocation;
import com.project.demo.service.RefereeAllocationService;
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
 *裁判分配：(RefereeAllocation)表控制层
 *
 */
@RestController
@RequestMapping("/referee_allocation")
public class RefereeAllocationController extends BaseController<RefereeAllocation,RefereeAllocationService> {

    /**
     *裁判分配对象
     */
    @Autowired
    public RefereeAllocationController(RefereeAllocationService service) {
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
