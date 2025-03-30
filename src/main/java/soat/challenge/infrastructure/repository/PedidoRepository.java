package soat.challenge.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soat.challenge.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {



}
