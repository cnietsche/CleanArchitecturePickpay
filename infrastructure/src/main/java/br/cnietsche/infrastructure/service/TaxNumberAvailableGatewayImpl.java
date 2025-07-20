package br.cnietsche.infrastructure.service;

import br.cnietsche.infrastructure.repository.AppUserRepository;
import br.com.cnietsche.application.gateway.TaxNumberAvailableGateway;
import org.springframework.stereotype.Service;
import static br.cnietsche.infrastructure.utils.Utilities.log;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {

    private final AppUserRepository appUserRepository;

    public TaxNumberAvailableGatewayImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        log.info("Start of tax number availability::TaxNumberAvailableGatewayImpl");
        return !appUserRepository.existsByTaxNumber(taxNumber);
    }
}
