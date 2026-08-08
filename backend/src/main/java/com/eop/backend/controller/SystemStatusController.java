package com.eop.backend.controller;

import com.eop.backend.dto.SystemStatusResponse;
import com.eop.backend.service.SystemStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system")
public class SystemStatusController {

    private final SystemStatusService systemStatusService;

    public SystemStatusController(SystemStatusService systemStatusService) {
        this.systemStatusService = systemStatusService;
    }

    @GetMapping("/status")
    public SystemStatusResponse getSystemStatus() {
        return systemStatusService.getSystemStatus();
    }
}