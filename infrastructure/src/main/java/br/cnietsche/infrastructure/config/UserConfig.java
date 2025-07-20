package br.cnietsche.infrastructure.config;

import br.com.cnietsche.application.gateway.CreateUserGateway;
import br.com.cnietsche.application.gateway.EmailAvailableGateway;
import br.com.cnietsche.application.gateway.TaxNumberAvailableGateway;
import br.com.cnietsche.application.usecaseimpl.CreateUserUseCaseImpl;
import br.com.cnietsche.application.usecaseimpl.EmailAvailableUseCaseImpl;
import br.com.cnietsche.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import br.com.cnietsche.usecase.CreateUserUseCase;
import br.com.cnietsche.usecase.EmailAvailableUseCase;
import br.com.cnietsche.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway) {
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(
            CreateUserGateway createUserGateway,
            TaxNumberAvailableUseCase taxNumberAvailableUseCase,
            EmailAvailableUseCase emailAvailableUseCase) {
        return new CreateUserUseCaseImpl(createUserGateway, taxNumberAvailableUseCase, emailAvailableUseCase);
    }
}
