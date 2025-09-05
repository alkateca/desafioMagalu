package com.alkateca.desafiomagalu.model;

import com.alkateca.desafiomagalu.enums.TipoComunicacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
