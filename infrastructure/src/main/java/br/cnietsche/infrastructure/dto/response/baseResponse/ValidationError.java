package br.cnietsche.infrastructure.dto.response.baseResponse;

public record ValidationError(String field, String message) {
}
