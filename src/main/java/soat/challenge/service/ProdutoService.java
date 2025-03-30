package soat.challenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soat.challenge.domain.model.Produto;
import soat.challenge.domain.enums.CategoriaEnum;
import soat.challenge.domain.port.ProdutoRepositoryPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    @Transactional
    public Produto criarProduto(Produto produto) {
        return produtoRepositoryPort.save(produto);
    }

    @Transactional
    public Produto atualizarProduto(Long id, Produto produto) {
        Produto existente = produtoRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        existente.setNome(produto.getNome());
        existente.setDescricao(produto.getDescricao());
        existente.setPreco(produto.getPreco());
        existente.setCategoria(produto.getCategoria());
        return produtoRepositoryPort.update(existente);
    }

    @Transactional
    public void removerProduto(Long id) {
        produtoRepositoryPort.deleteById(id);
    }

    public List<Produto> buscarPorCategoria(CategoriaEnum categoria) {
        return produtoRepositoryPort.findByCategoria(categoria);
    }

    public List<Produto> buscarTodos() {
        return produtoRepositoryPort.findAll();
    }
}
