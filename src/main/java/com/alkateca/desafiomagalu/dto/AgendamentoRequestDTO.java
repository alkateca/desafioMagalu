package com.alkateca.desafiomagalu.dto;

import com.alkateca.desafiomagalu.enums.TipoComunicacao;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO (
        String destinatario,
        String mensagem,
        TipoComunicacao tipoComunicacao,
        LocalDateTime dataHoraEnvio){
}
