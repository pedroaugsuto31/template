package br.gov.ce.sps.template.domain.service.aluno;

import br.gov.ce.sps.template.domain.exception.CpfJaCadastradoException;
import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroAlunoService {

    private final AlunoRepository alunoRepository;

    @Transactional
    public Aluno salvar(Aluno aluno) {
        if (aluno.getCpf() != null && alunoRepository.existsByCpf(aluno.getCpf())) {
            throw new CpfJaCadastradoException("Já existe um Aluno cadastrado com o CPF informado");
        }

        return alunoRepository.save(aluno);
    }

}
