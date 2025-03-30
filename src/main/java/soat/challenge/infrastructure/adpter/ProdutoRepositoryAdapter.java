package soat.challenge.infrastructure.adpter;

import org.springframework.stereotype.Component;
import soat.challenge.domain.model.Produto;
import soat.challenge.domain.enums.CategoriaEnum;
import soat.challenge.domain.port.ProdutoRepositoryPort;
import soat.challenge.infrastructure.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoRepository produtoRepository;

    public ProdutoRepositoryAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public List<Produto> findByCategoria(CategoriaEnum categoria) {
        return produtoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
