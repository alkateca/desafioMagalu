package com.alkateca.desafiomagalu.repository;

import com.alkateca.desafiomagalu.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
