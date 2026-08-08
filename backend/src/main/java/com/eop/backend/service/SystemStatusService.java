package com.eop.backend.service;

import com.eop.backend.dto.SystemStatusResponse;
import org.springframework.stereotype.Service;

@Service
public class SystemStatusService {

    public SystemStatusResponse getSystemStatus() {
        return new SystemStatusResponse(
                "Enterprise Operations Platform",
                "UP"
        );
    }
}