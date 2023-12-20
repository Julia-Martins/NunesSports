package com.example.nunes_sports.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nunes_sports.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}