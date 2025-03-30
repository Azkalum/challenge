package soat.challenge.infrastructure.adpter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import soat.challenge.domain.model.Cliente;
import soat.challenge.domain.port.ClienteRepositoryPort;
import soat.challenge.infrastructure.repository.ClienteRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}