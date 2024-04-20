package br.edu.utfpr.todoapi.dto;

import jakarta.validation.constraints.NotBlank;

public record DispositivoDTO(
    @NotBlank String nome,
    @NotBlank String descricao,
    String localizacao,
    String endereco,
    Long idGateway,
    Long idSensor,
    Long idAtuador) {
}
