package dio.spring.boot.gof.service.impl;

import dio.spring.boot.gof.model.Cliente;
import dio.spring.boot.gof.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

    // TODO Singleton: Injetar os componentes do Spring com @Autowired
    // TODO Strategy: Implementar os métodos definidos na interface
    // TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples
    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME Buscar todos os Clientes.
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // FIXME Buscar Cliente por ID.
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        // FIXME Verificar se o endereço do Cliente já existe (pelo cep)
        // FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno
        // FIXME Inserir Cliente, vinculando o Endereço (novo ou existente)
    }

    @Override
    public void atualizar(Cliente cliente) {
        // FIXME Buscar Cliente por ID, caso exista
        // FIXME Verificar se o endereço do Cliente já existe (pelo cep)
        // FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno
        // FIXME Atualizar Cliente, vinculando o Endereço (novo ou existente)
    }

    @Override
    public void deletar(Long id) {
        // FIXME Deletar Cliente por ID
    }
}
