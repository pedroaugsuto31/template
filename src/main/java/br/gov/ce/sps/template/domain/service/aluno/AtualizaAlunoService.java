package br.gov.ce.sps.template.domain.service.aluno;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizaAlunoService {

    private final AlunoRepository alunoRepository;

    @Transactional
    public Aluno atualizar(Aluno aluno) {
        if (aluno.getId() == null || aluno.getCodigo() == null) {
            throw new EntidadeNaoEncontradaException("Aluno não encontrado");
        }

        return alunoRepository.save(aluno);
    }

}
