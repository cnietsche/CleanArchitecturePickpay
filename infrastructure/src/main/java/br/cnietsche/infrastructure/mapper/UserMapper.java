package br.cnietsche.infrastructure.mapper;

import br.cnietsche.infrastructure.dto.request.CreateUserRequestDTO;
import br.cnietsche.infrastructure.entity.AppUser;
import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.User;
import br.com.cnietsche.core.exception.TaxNumberException;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public AppUser toEntity(User user) {
        return new AppUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullName(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdatedAt());
    }

    public User toEntity(CreateUserRequestDTO request) throws TaxNumberException {
        return new User(
                request.email(),
                request.password(),
                new TaxNumber(request.taxNumber()),
                request.fullName(),
                request.type());
    }
}
