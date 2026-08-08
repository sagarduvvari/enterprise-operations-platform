package com.eop.backend.dto;

public record SystemStatusResponse(
        String application,
        String status
) {
}