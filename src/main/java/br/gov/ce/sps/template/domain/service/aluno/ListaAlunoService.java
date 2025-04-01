package br.gov.ce.sps.template.domain.service.aluno;

import br.gov.ce.sps.template.domain.filter.AlunoFilter;
import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.repository.AlunoRepository;
import br.gov.ce.sps.template.domain.spec.aluno.AlunoSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaAlunoService {

    private final AlunoRepository alunoRepository;

    public List<Aluno> listarTodas() {
        return alunoRepository.findAll(Sort.by(Sort.Direction.DESC, "dataCadastro"));
    }

    public Page<Aluno> listar(AlunoFilter filtro, Pageable pageable) {
        return alunoRepository.findAll(AlunoSpec.usandoFiltro(filtro), pageable);
    }

}
