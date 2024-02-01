/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.com.employee_database.entities.services.Impl;

import employee.com.employee_database.entities.Produto;
import employee.com.employee_database.entities.ProdutoCategoria;
import employee.com.employee_database.entities.dtos.ProdutoDto;
import employee.com.employee_database.entities.repositories.ProdutoCategoriaRepository;
import employee.com.employee_database.entities.repositories.ProdutoRepository;
import employee.com.employee_database.entities.services.ProdutoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoCategoriaRepository produtoCategoriaRepository;

////    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
////        this.produtoRepository = produtoRepository;
////    }

    @Override
    public Produto produtoSalvar(ProdutoDto produto) {
        System.err.println("1");
        Boolean tea = this.produtoRepository.existsByNomeOrCodigo(produto.getNome(), produto.getCodigo());
        System.err.println(tea);
        if (!tea) {
            System.err.println("2");
            Produto produtoSalvar = new Produto();
            produtoSalvar.setNome(produto.getNome());
            produtoSalvar.setCodigo(produto.getCodigo());
            produtoSalvar.setPreco(produto.getPreco());
            ProdutoCategoria produtoCategoria= this.produtoCategoriaRepository.buscarCategoriaProdutoByPkProdutoCategoria(produto.getFk_produto_categoria());
            if (produtoCategoria == null){
                return null;
            }
            produtoSalvar.setFk_produto_categoria(produtoCategoria);
            
            return produtoRepository.save(produtoSalvar);

        }
        return null;
    }

    @Override
    public List<Produto> produtoListar() {
        List<Produto> produtoListar = this.produtoRepository.findAllProdutoOrderByNome();
        if (produtoListar != null) {
            return produtoListar;
        }
        return null;

    }

    @Override
    public Produto produtoAtualizar(ProdutoDto produto, int pk_produto) {
        
        Produto produtoAtualizar = this.produtoPesquisarByPkProduto(pk_produto);

        if (produtoAtualizar != null) {

            produtoAtualizar.setNome(produto.getNome());
            produtoAtualizar.setCodigo(produto.getCodigo());
            produtoAtualizar.setPreco(produto.getPreco());
            ProdutoCategoria produtoCategoria= this.produtoCategoriaRepository.buscarCategoriaProdutoByPkProdutoCategoria(produto.getFk_produto_categoria());
            if (produtoCategoria == null){
                return null;
            }
            produtoAtualizar.setFk_produto_categoria(produtoCategoria);
            return this.produtoRepository.save(produtoAtualizar);
        }
        return null;
    }

    @Override
    public List<Produto> produtoDeletar(int pk_produto) {
        Produto produtoDeletar = this.produtoPesquisarByPkProduto(pk_produto);
        if (produtoDeletar != null) {
            this.produtoRepository.deleteById(pk_produto);
            return this.produtoListar();
        }
        return null;
    }

    @Override
    public Produto produtoPesquisarByPkProduto(int pk_produto) {
        return this.produtoRepository.produtoPequisarByPkProduto(pk_produto);
    }

    @Override
    public Produto produtoPesquisarByNome(String nome) {
        return this.produtoRepository.findByNome(nome);
    }

    @Override
    public Produto buscarProdutoMaiorPreco() {

        Produto produtoMaiorPreco = this.produtoRepository.buscarProdutoMaiorPreco();

        if (produtoMaiorPreco == null) {

            return null;
        }

        return produtoMaiorPreco;
    }

//    @Override
//    public Produto produtoAtualizar(Produto produto, int pk_produto) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
