package com.example.nunes_sports.dtos;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrorDTO {
    @Getter
    private List<String> errors;

    public ApiErrorDTO(String mensagem){
        errors = Arrays.asList(mensagem);
    }
}
