package com.yangzhou.intelligent.Controller;

import com.yangzhou.intelligent.Service.PatientService;
import com.yangzhou.intelligent.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ResponseResult
@CrossOrigin
@RequestMapping(value = "/monitor")
public class MonitorController {
    @Autowired
    private PatientService patientService;
}
