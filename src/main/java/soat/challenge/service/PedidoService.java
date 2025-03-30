package soat.challenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soat.challenge.domain.model.ItemPedido;
import soat.challenge.domain.model.Pedido;
import soat.challenge.domain.enums.StatusPedidoEnum;
import soat.challenge.domain.port.PedidoRepositoryPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    @Transactional
    public Pedido realizarCheckout(Pedido pedido) {

        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {

                item.setPedido(pedido);
            }
        }

        pedido.setStatus(StatusPedidoEnum.RECEBIDO);

        return pedidoRepositoryPort.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepositoryPort.findAll();
    }

    public Pedido obterPedido(Long id) {
        return pedidoRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
