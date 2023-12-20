package com.example.nunes_sports.services;

import java.util.List;

import com.example.nunes_sports.dtos.DadosProdutoDTO;
import com.example.nunes_sports.dtos.ProdutoDTO;
import com.example.nunes_sports.models.Produto;

public interface ProdutoService {
    Produto salvar(ProdutoDTO produtoDTO);
    List<ProdutoDTO> listAll();
    DadosProdutoDTO obtainById(Integer id);

    void deleteProdutoById(Integer id);
    void updateProduto(Integer id, ProdutoDTO dto);
}
