package com.example.nunes_sports.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome_prod;
    private String descricao_prod;
    private double preco_prod;

    public Produto(){}
    
    public Produto(Integer id, String nome_prod, String descricao_prod, double preco_prod) {
        this.id = id;
        this.nome_prod = nome_prod;
        this.descricao_prod = descricao_prod;
        this.preco_prod = preco_prod;
    }

    @Override
    public String toString() {
        return "[" + 
            id + ", " +
            nome_prod + ", " +
            descricao_prod + ", " + 
            preco_prod +
        "]";
    }
}
