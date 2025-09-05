package com.alkateca.desafiomagalu.service;

import com.alkateca.desafiomagalu.dto.AgendamentoRequestDTO;
import com.alkateca.desafiomagalu.dto.AgendamentoResponseDTO;
import com.alkateca.desafiomagalu.model.Agendamento;
import com.alkateca.desafiomagalu.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoResponseDTO agendar(AgendamentoRequestDTO agendamentoRequestDTO) {
        Agendamento agendamento = Agendamento.builder()
                .destinatario(agendamentoRequestDTO.destinatario())
                .mensagem(agendamentoRequestDTO.mensagem())
                .tipoComunicacao(agendamentoRequestDTO.tipoComunicacao())
                .dataHoraEnvio(LocalDateTime.now())
                .build();

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);

        return toResponse(agendamento);
    }

    public AgendamentoResponseDTO buscarPorID(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
        return toResponse(agendamento);
    }

    public void remover(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }

    public AgendamentoResponseDTO toResponse(Agendamento agendamento) {
        return new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getDestinatario(),
                agendamento.getMensagem(),
                agendamento.getTipoComunicacao(),
                agendamento.getDataHoraEnvio()
        );
    }
}
