package employee.com.employee_database.controllers;

import employee.com.employee_database.entities.Produto;
import employee.com.employee_database.entities.dtos.ProdutoDto;
import employee.com.employee_database.entities.services.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jacinto
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    
    private ProdutoService produtoService;

//    public ProdutoController(ProdutoService produtoService) {
//        this.produtoService = produtoService;
//    }

    /*
    Nome do metodo : PordutoListar
    Parametro: Vazio
    Retorno: Lista de produto
     */
    @GetMapping("/produtoListar")
    @SuppressWarnings("empty-statement")
    public ResponseEntity<List<Produto>> produtoListar() {

        List<Produto> listaProduto = this.produtoService.produtoListar();

        if (listaProduto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(listaProduto);

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaProduto);

    }

    @PostMapping("/produtoSalvar")
    public ResponseEntity<Produto> produtoSalvar(@RequestBody ProdutoDto produto) {

        Produto produtoSalvo = this.produtoService.produtoSalvar(produto);
     
        if (produtoSalvo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);

    }

    @GetMapping("/produtoPesquisarByNome/{nome}")
    @SuppressWarnings("empty-statement")
    public ResponseEntity<Produto> produtoPesquisarByNome(@PathVariable(value = "nome") String nome) {

        Produto produtoPequisado = this.produtoService.produtoPesquisarByNome(nome);

        if (produtoPequisado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(produtoPequisado);

        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);

    }

    @GetMapping("/produtoPesquisarByPkProduto/{pk_produto}")
    @SuppressWarnings("empty-statement")
    public ResponseEntity<Produto> produtoPesquisarByPkProduto(@PathVariable(value = "pk_produto") Integer pk_produto) {

        Produto produtoPequisado = this.produtoService.produtoPesquisarByPkProduto(pk_produto);

        if (produtoPequisado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(produtoPequisado);

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    @PutMapping("/produtoAtualizar/{pk_produto}")
    public ResponseEntity<Produto> produtoAtualizar(@RequestBody ProdutoDto produto, @PathVariable(value = "pk_produto") int pk_produto) {

        Produto produtoAtualizar = this.produtoService.produtoAtualizar(produto, pk_produto);

        if (produtoAtualizar == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoAtualizar);

    }

    @DeleteMapping("/produtoDeletar/{pk_produto}")
    public ResponseEntity<List<Produto>> produtoDeletar(@PathVariable(value = "pk_produto") int pk_produto) {

        List<Produto> produtoDeletar = this.produtoService.produtoDeletar(pk_produto);

        if (produtoDeletar == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoDeletar);

    }

    @GetMapping("/buscarProdutoMaiorPreco")
    @SuppressWarnings("empty-statement")
    public ResponseEntity<Produto> buscarProdutoMaiorPreco() {

        Produto buscarProdutoMaiorPreco = this.produtoService.buscarProdutoMaiorPreco();

        if (buscarProdutoMaiorPreco != null) {
            return ResponseEntity.status(HttpStatus.OK).body(buscarProdutoMaiorPreco);

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

}
