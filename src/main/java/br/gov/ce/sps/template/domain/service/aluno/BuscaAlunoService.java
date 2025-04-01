package br.gov.ce.sps.template.domain.service.aluno;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscaAlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno findById(Long id) {
        return alunoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Aluno com id " + id + " não encontrado"));
    }

    public Aluno findByCode(UUID codigo) {
        return alunoRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Aluno não encontrado"));
    }

}
