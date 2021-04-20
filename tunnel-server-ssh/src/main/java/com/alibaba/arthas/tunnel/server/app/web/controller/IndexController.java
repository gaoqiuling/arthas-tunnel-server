package com.alibaba.arthas.tunnel.server.app.web.controller;

import com.alibaba.arthas.tunnel.server.app.web.response.dto.request.PidRequest;
import com.alibaba.arthas.tunnel.server.app.web.response.dto.response.ProcessPageResponse;
import com.alibaba.arthas.tunnel.server.app.web.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/backend")
public class IndexController {
    @Autowired
    private ProcessService processService;

    @ResponseBody
    @GetMapping(value = "/get_process_ist")
    public ProcessPageResponse getProcessList(@RequestParam String ip) {
        return processService.getProcessList(ip);
    }

    @ResponseBody
    @GetMapping(value = "/attach")
    public void attach(PidRequest request) {
        processService.attach(request);
    }
}
