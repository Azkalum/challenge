package soat.challenge.domain.port;

import soat.challenge.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {

    Cliente save(Cliente cliente);
    Optional<Cliente> findByCpf(String cpf);

}
