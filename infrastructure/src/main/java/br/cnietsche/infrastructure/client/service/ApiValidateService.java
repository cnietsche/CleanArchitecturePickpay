package br.cnietsche.infrastructure.client.service;

import br.cnietsche.infrastructure.client.ApiValidateClient;
import br.cnietsche.infrastructure.client.dto.ApiValidateResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ApiValidateService {

    private final ApiValidateClient apiValidateClient;

    public ApiValidateService(ApiValidateClient apiValidateClient) {
        this.apiValidateClient = apiValidateClient;
    }

    public ApiValidateResponseDto validate() {
        try {
            return apiValidateClient.validate();
        } catch (Exception e) {
            return null;
        }
    }
}
