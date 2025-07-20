package br.cnietsche.infrastructure.dto.response;

import br.cnietsche.infrastructure.dto.response.baseResponse.ErrorResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponseDTO<T> {

    private Boolean success;
    private String message;
    private T result;
    private ErrorResponse error;
}
