package org.sopt.server.dto.request;

import jakarta.validation.constraints.NotBlank;

public record MemberCreateRequest(
        @NotBlank
        String name
) {
}
