package br.gov.ce.sps.template.domain.service.professor;

import br.gov.ce.sps.template.domain.exception.CpfJaCadastradoException;
import br.gov.ce.sps.template.domain.model.Professor;
import br.gov.ce.sps.template.domain.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroProfessorService {

    private final ProfessorRepository professorRepository;

    @Transactional
    public Professor salvar(Professor professor) {
        if (professor.getCpf() != null && professorRepository.existsByCpf(professor.getCpf())) {
            throw new CpfJaCadastradoException("Já existe um Professor cadastrado com o CPF informado");
        }

        return professorRepository.save(professor);
    }

}
