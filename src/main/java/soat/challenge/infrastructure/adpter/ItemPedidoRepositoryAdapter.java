package soat.challenge.infrastructure.adpter;

import org.springframework.stereotype.Component;
import soat.challenge.domain.model.ItemPedido;
import soat.challenge.domain.port.ItemPedidoRepositoryPort;
import soat.challenge.infrastructure.repository.ItemPedidoRepository;

import java.util.Optional;

@Component
public class ItemPedidoRepositoryAdapter implements ItemPedidoRepositoryPort {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoRepositoryAdapter(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @Override
    public ItemPedido save(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    @Override
    public Optional<ItemPedido> findById(Long id) {
        return itemPedidoRepository.findById(id);
    }
}
