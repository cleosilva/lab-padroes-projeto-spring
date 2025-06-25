package dio.spring.boot.gof.service.impl;

import dio.spring.boot.gof.model.Cliente;
import dio.spring.boot.gof.model.ClienteRepository;
import dio.spring.boot.gof.model.Endereco;
import dio.spring.boot.gof.model.EnderecoRepository;
import dio.spring.boot.gof.service.ClienteService;
import dio.spring.boot.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injetar os componentes do Spring com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        // Buscar Cliente por ID.
        return clienteRepository.findById(id);

    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista
        Optional<Cliente> clienteById = clienteRepository.findById(id);
        if(clienteById.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o endereço do Cliente já existe (pelo cep)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereço (novo ou existente)
        clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID
        clienteRepository.deleteById(id);
    }
}
