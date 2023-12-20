package com.example.nunes_sports.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.nunes_sports.dtos.DadosProdutoDTO;
import com.example.nunes_sports.dtos.ProdutoDTO;
import com.example.nunes_sports.exceptions.RegraNegocioException;
import com.example.nunes_sports.models.Produto;
import com.example.nunes_sports.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImplementation implements ProdutoService{
    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(ProdutoDTO produtoDTO) {
        Produto p = new Produto();
        p.setNome_prod(produtoDTO.getNome_prod());
        p.setDescricao_prod(produtoDTO.getDescricao_prod());
        p.setPreco_prod(produtoDTO.getPreco_prod());

        return produtoRepository.save(p);
    }

    @Override
    public List<ProdutoDTO> listAll() {
        List<ProdutoDTO> produtoDTOs = produtoRepository.findAll().stream().map(
            (Produto p) -> {
                return ProdutoDTO.builder()
                .id(p.getId())
                .nome_prod(p.getNome_prod())
                .descricao_prod(p.getDescricao_prod())
                .preco_prod(p.getPreco_prod())
                .build();
            }
        ).collect(Collectors.toList());

        return produtoDTOs;
    }

    @Override
    public DadosProdutoDTO obtainById(Integer id) {
        return produtoRepository.findById(id).map(
            (Produto p) -> {
                return 
                DadosProdutoDTO.builder()
                .id(p.getId())
                .nome_prod(p.getNome_prod())
                .descricao_prod(p.getDescricao_prod())
                .preco_prod(p.getPreco_prod())
                .build();
            }
        ).orElseThrow(
            () -> new RegraNegocioException("Produto não encontrado com o ID Fornecido!")
        );
    }

    @Override
    @Transactional
    public void deleteProdutoById(Integer id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public void updateProduto(Integer id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException("Código usuário não encontrado."));

        produto.setNome_prod(dto.getNome_prod());
        produto.setDescricao_prod(dto.getDescricao_prod());
        produto.setPreco_prod(dto.getPreco_prod());
        produtoRepository.save(produto);
    }
    
}
