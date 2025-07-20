package br.cnietsche.infrastructure.service;

import br.cnietsche.infrastructure.repository.AppUserRepository;
import br.com.cnietsche.application.gateway.EmailAvailableGateway;
import org.springframework.stereotype.Service;
import static br.cnietsche.infrastructure.utils.Utilities.log;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {

    private final AppUserRepository appUserRepository;

    public EmailAvailableGatewayImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        log.info("Start of email availability::EmailAvailableGatewayImpl");
        return !appUserRepository.existsByEmail(email);
    }
}
