package br.cnietsche.infrastructure.dto.request;

import br.com.cnietsche.core.domain.enums.UserTypeEnum;

public record CreateUserRequestDTO(
        String email,
        String password,
        String taxNumber,
        String fullName,
        UserTypeEnum type,
        String pin) {
}
