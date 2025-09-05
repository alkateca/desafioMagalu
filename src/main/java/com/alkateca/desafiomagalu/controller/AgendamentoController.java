package com.alkateca.desafiomagalu.controller;

import com.alkateca.desafiomagalu.dto.AgendamentoRequestDTO;
import com.alkateca.desafiomagalu.dto.AgendamentoResponseDTO;
import com.alkateca.desafiomagalu.model.Agendamento;
import com.alkateca.desafiomagalu.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> agendar(@RequestBody AgendamentoRequestDTO agendamentoRequestDTO) {
        AgendamentoResponseDTO agendamentoResponseDTO = agendamentoService.agendar(agendamentoRequestDTO);
        return ResponseEntity.ok(agendamentoResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> buscaPorID(@PathVariable Long id) {
        AgendamentoResponseDTO agendamentoResponseDTO = agendamentoService.buscarPorID(id);
        return ResponseEntity.ok(agendamentoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        agendamentoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
