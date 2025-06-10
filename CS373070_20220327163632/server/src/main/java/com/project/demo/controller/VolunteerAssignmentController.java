package com.project.demo.controller;

import com.project.demo.entity.VolunteerAssignment;
import com.project.demo.service.VolunteerAssignmentService;
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
 *志愿者分配：(VolunteerAssignment)表控制层
 *
 */
@RestController
@RequestMapping("/volunteer_assignment")
public class VolunteerAssignmentController extends BaseController<VolunteerAssignment,VolunteerAssignmentService> {

    /**
     *志愿者分配对象
     */
    @Autowired
    public VolunteerAssignmentController(VolunteerAssignmentService service) {
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
