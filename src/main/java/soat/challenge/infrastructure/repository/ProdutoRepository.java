package soat.challenge.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soat.challenge.domain.model.Produto;
import soat.challenge.domain.enums.CategoriaEnum;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoria(CategoriaEnum categoria);

}
