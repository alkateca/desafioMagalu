package com.alkateca.desafiomagalu.model;

import com.alkateca.desafiomagalu.enums.TipoComunicacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false)
    private LocalDateTime dataHoraEnvio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoComunicacao tipoComunicacao;

    @Column(nullable = false)
    private String mensagem;
}
