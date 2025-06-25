package dio.spring.boot.gof.service;

import dio.spring.boot.gof.model.Cliente;

/**
 * Interface que define o padrão Strategy no domínio de cliente.
 * **/

public interface ClienteService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);
    void atualizar(Cliente cliente);
    void deletar(Long id);

}
