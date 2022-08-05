package com.project.zvukiznanje.security.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UnauthorizedResponseDTO {
    private final String customMessage;
    private final String exceptionMessage;
}
