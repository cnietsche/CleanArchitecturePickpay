package br.cnietsche.infrastructure.dto.response.baseResponse;

import java.util.List;

public record ErrorResponse(
        String code,
        String message,
        List<ValidationError> validation
) {
}
