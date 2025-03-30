package soat.challenge.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soat.challenge.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

}
