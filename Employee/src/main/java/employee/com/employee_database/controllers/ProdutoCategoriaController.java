/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.controllers;

import employee.com.employee_database.entities.ProdutoCategoria;
import employee.com.employee_database.entities.services.ProdutoCategoriaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jacinto
 */
@RestController
@RequestMapping("/categoria")
public class ProdutoCategoriaController {

    private ProdutoCategoriaService produtoCategoriaService;

    public ProdutoCategoriaController(ProdutoCategoriaService produtoCategoriaService) {
        this.produtoCategoriaService = produtoCategoriaService;
    }

    @GetMapping("/produtoCategoriaListar")
    public ResponseEntity<List<ProdutoCategoria>> produtoCategoriaListar() {
        List<ProdutoCategoria> produtoCategoriaListar = this.produtoCategoriaService.produtoCategoriaListar();
        if (produtoCategoriaListar == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCategoriaListar);
    }

    @PostMapping("/produtoCategoriaSalvar")
    public ResponseEntity<ProdutoCategoria> produtoCategoriaSalvar(@Validated @RequestBody ProdutoCategoria produtoCategoria) {
        ProdutoCategoria produtoCategoriaSalvar = this.produtoCategoriaService.produtoCategoriaSalvar(produtoCategoria);
        if (produtoCategoriaSalvar == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(produtoCategoria);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCategoriaSalvar);
    }

    @GetMapping("/produtoCategoriaByDesignacao/{designacao_produto_categoria}")
    public ResponseEntity<ProdutoCategoria> produtoCategoriaByDesignacao(@PathVariable(value = "designacao_produto_categoria") String designacao_produto_categoria) {
        ProdutoCategoria buscarProdutoCategoriaByNome = this.produtoCategoriaService.produtoCategoriaByDesignacao(designacao_produto_categoria);
        if (buscarProdutoCategoriaByNome == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(buscarProdutoCategoriaByNome);
    }

    @GetMapping("/buscarCategoriaProdutoByPkProdutoCategoria/{pk_produto_categoria}")
    public ResponseEntity<ProdutoCategoria> buscarCategoriaProdutoByPkProdutoCategoria(@PathVariable(value = "pk_produto_categoria") int pk_produto_categoria) {
        ProdutoCategoria buscarProdutoCategoriaByNome = this.produtoCategoriaService.buscarCategoriaProdutoByPkProdutoCategoria(pk_produto_categoria);
        if (buscarProdutoCategoriaByNome == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(buscarProdutoCategoriaByNome);
    }
}
