package br.edu.utfpr.todoapi.dto;

import jakarta.validation.constraints.NotBlank;

public record DispositivoDTO(
    @NotBlank String nome,
    @NotBlank String descricao,
    String localizacao,
    Long idGateway,
    Long idSensor,
    Long idAtuador) {
}
