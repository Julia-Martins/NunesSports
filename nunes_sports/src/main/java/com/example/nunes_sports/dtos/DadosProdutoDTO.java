package com.example.nunes_sports.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DadosProdutoDTO {
    private Integer id;
    private String nome_prod;
    private String descricao_prod;
    private double preco_prod;
}
