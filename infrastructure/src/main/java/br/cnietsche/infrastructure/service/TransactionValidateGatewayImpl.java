package br.cnietsche.infrastructure.service;

import br.cnietsche.infrastructure.client.service.ApiValidateService;
import br.com.cnietsche.application.gateway.TransactionValidateGateway;
import br.com.cnietsche.core.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {

    private final ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        var response = apiValidateService.validate();
        if (Objects.isNull(response)) {
            return false;
        }
        return response.success();
    }
}
