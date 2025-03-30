package soat.challenge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soat.challenge.service.PedidoService;
import soat.challenge.domain.model.Pedido;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
@Tag(name = "Pedidos", description = "Endpoints para gerenciamento de pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Operation(summary = "Realizar checkout", description = "Endpoint para finalizar o pedido e enviá-lo para a fila")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido finalizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping("/checkout")
    public ResponseEntity<Pedido> realizarCheckout(@RequestBody Pedido pedido) {
        Pedido pedidoCriado = pedidoService.realizarCheckout(pedido);
        return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
    }

    @Operation(summary = "Listar pedidos", description = "Endpoint para listar todos os pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos")
    })
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @Operation(summary = "Obter pedido", description = "Endpoint para obter detalhes de um pedido pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalhes do pedido"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.obterPedido(id);
        return ResponseEntity.ok(pedido);
    }
}
