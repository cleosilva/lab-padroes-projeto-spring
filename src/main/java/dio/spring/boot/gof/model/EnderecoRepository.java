package dio.spring.boot.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EnderecoRepository extends CrudRepository<Endereco, String> {
}
