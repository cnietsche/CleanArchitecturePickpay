package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.TaxNumberAvailableGateway;
import br.com.cnietsche.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
