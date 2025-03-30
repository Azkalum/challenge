package soat.challenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soat.challenge.domain.model.Cliente;
import soat.challenge.domain.port.ClienteRepositoryPort;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepositoryPort clienteRepositoryPort;

    @Transactional
    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepositoryPort.save(cliente);
    }

    public Cliente buscarPorCpf(String cpf) {
        return clienteRepositoryPort.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
