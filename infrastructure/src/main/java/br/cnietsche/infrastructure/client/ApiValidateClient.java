package br.cnietsche.infrastructure.client;

import br.cnietsche.infrastructure.client.dto.ApiValidateResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidateClient", url = "${client.url}")
public interface ApiValidateClient {

    @GetMapping
    ApiValidateResponseDto validate();
}
