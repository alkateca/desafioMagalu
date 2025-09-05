package com.alkateca.desafiomagalu.dto;

import com.alkateca.desafiomagalu.enums.TipoComunicacao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO (
        @NotBlank(message = "Destinatário não pode ser vazio")
        String destinatario,
        @NotBlank(message = "Mensagem não pode ser vazia")
        String mensagem,
        @NotBlank(message = "O tipo de comunicação não pode ser vazio")
        TipoComunicacao tipoComunicacao,
        @NotBlank(message = "Data e hora não pode ser vazio")
        @Future(message = "Data e hora devem ser futuras")
        LocalDateTime dataHoraEnvio){
}
