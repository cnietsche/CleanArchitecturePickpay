package br.cnietsche.infrastructure.controller;

import br.cnietsche.infrastructure.dto.request.CreateUserRequestDTO;
import br.cnietsche.infrastructure.dto.response.BaseResponseDTO;
import br.cnietsche.infrastructure.mapper.UserMapper;
import br.com.cnietsche.core.exception.EmailException;
import br.com.cnietsche.core.exception.InternalServerErrorException;
import br.com.cnietsche.core.exception.TaxNumberException;
import br.com.cnietsche.core.exception.TransactionPinException;
import br.com.cnietsche.usecase.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.cnietsche.infrastructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class AppUserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;

    public AppUserController(
            CreateUserUseCase createUserUseCase,
            UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/create")
    public BaseResponseDTO<String> createUser(@RequestBody CreateUserRequestDTO request)
            throws TaxNumberException, EmailException, InternalServerErrorException, TransactionPinException {
        log.info("Start of user creation::AppUserController");
        createUserUseCase.create(userMapper.toEntity(request), request.pin());
        log.info("End of user creation::AppUserController");
        return BaseResponseDTO.<String>builder().success(true).message("User successfully created").build();
    }
}
