package soat.challenge.domain.port;

import soat.challenge.domain.model.Produto;
import soat.challenge.domain.enums.CategoriaEnum;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {

    Produto save(Produto produto);
    Optional<Produto> findById(Long id);
    Produto update(Produto produto);
    void deleteById(Long id);
    List<Produto> findByCategoria(CategoriaEnum categoria);
    List<Produto> findAll();

}
