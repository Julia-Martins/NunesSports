package com.example.nunes_sports.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.nunes_sports.dtos.DadosProdutoDTO;
import com.example.nunes_sports.dtos.ProdutoDTO;
import com.example.nunes_sports.services.ProdutoService;

import java.util.List;

@RestController
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/produto")
    public List<ProdutoDTO> getAllProdutos(){
        return produtoService.listAll();
    }

    @GetMapping("/produto/{id}")
    public DadosProdutoDTO getAllProdutos(@PathVariable Integer id){
        return produtoService.obtainById(id);
    }

    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertProduto(@RequestBody ProdutoDTO produto) {
        produtoService.salvar(produto);
    }

    @PutMapping("/produto")
    public void updateProduto(@PathVariable Integer id, @RequestBody ProdutoDTO produto) {
        produtoService.updateProduto(id, produto);
    }
    
    @DeleteMapping("/produto/{id}")
    public void deleteProduto(@PathVariable Integer id) {
        produtoService.deleteProdutoById(id);
    }
}
