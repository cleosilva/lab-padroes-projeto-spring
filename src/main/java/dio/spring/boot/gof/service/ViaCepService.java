package dio.spring.boot.gof.service;

import dio.spring.boot.gof.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client HTTP, criado via OpenFeign para consumo da API do ViaCep
 * **/

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService  {
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
