package soat.challenge.domain.port;

import soat.challenge.domain.model.ItemPedido;

import java.util.Optional;

public interface ItemPedidoRepositoryPort {

    ItemPedido save(ItemPedido itemPedido);
    Optional<ItemPedido> findById(Long id);
}
