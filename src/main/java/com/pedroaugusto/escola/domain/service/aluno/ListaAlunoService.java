package com.pedroaugusto.escola.domain.service.aluno;

import com.pedroaugusto.escola.domain.filter.AlunoFilter;
import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.repository.AlunoRepository;
import com.pedroaugusto.escola.domain.spec.aluno.AlunoSpec;
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
