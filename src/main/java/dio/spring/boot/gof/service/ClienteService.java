package dio.spring.boot.gof.service;

import dio.spring.boot.gof.model.Cliente;

import java.util.Optional;

/**
 * Interface que define o padrão Strategy no domínio de cliente.
 * **/

public interface ClienteService {
    Iterable<Cliente> buscarTodos();

    Optional<Cliente> buscarPorId(Long id);

    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);

}
