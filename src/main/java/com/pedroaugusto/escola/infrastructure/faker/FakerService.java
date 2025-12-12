package com.pedroaugusto.escola.infrastructure.faker;

import com.github.javafaker.Faker;
import com.pedroaugusto.escola.api.controller.*;
import com.pedroaugusto.escola.api.request.*;
import com.pedroaugusto.escola.domain.model.enums.DiaEnum;
import com.pedroaugusto.escola.domain.model.enums.SexoEnum;
import com.pedroaugusto.escola.domain.model.enums.TurnoEnum;
import com.pedroaugusto.escola.domain.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FakerService {

    private final AlunoController alunoController;
    private final AlunoRepository alunoRepository;

    private final TurmaController turmaController;
    private final TurmaRepository turmaRepository;

    private final DepartamentoController departamentoController;
    private final DepartamentoRepository departamentoRepository;

    private final DisciplinaController disciplinaController;
    private final DisciplinaRepository disciplinaRepository;

    private final ProfessorController professorController;
    private final ProfessorRepository professorRepository;

    private final CursoController cursoController;
    private final CursoRepository cursoRepository;

    private final Faker faker = new Faker(new Locale("pt", "BR"));
    private final Random random = new Random();

    public static String gerarCPF(Faker faker) {
        // Gerando uma string de 11 dígitos
        String cpf = faker.number().digits(11);

        // Formatando o CPF no formato XXX.XXX.XXX-XX
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }

    public static LocalDateTime gerarDataNascimento(int idadeMinima, int idadeMaxima) {
        Faker faker = new Faker();

        // Gerando uma data aleatória de aniversário entre a idade mínima e máxima
        Date data = faker.date().birthday(idadeMinima, idadeMaxima);

        // Convertendo Date para LocalDateTime
        return data.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public void populateAlunoTable(int numeroDeEntradas) {
        for (int i = 0; i < numeroDeEntradas; i++) {
            AlunoRequest aluno = new AlunoRequest();
            aluno.setNome(faker.name().fullName());
            aluno.setDataNascimento(gerarDataNascimento(18, 75));
            aluno.setRg(faker.number().digits(9));
            aluno.setOrgaoExpedidorRg(faker.space().agencyAbbreviation());
            aluno.setCpf(gerarCPF(faker));
            aluno.setSexo(faker.options().option(SexoEnum.values()));
            ContatoRequest contato = new ContatoRequest();
            contato.setTelefone(faker.phoneNumber().cellPhone());
            contato.setEmail(faker.internet().safeEmailAddress());
            aluno.setContato(contato);
            EnderecoRequest endereco = new EnderecoRequest();
            endereco.setCep(faker.address().zipCode());
            endereco.setLogradouro(faker.address().streetName());
            endereco.setLogradouroNumero(faker.address().streetAddressNumber());
            endereco.setComplemento(faker.address().secondaryAddress());
            endereco.setBairro(faker.address().cityName());
            endereco.setCidade(faker.address().city());
            endereco.setEstado(faker.address().stateAbbr());
            aluno.setEndereco(endereco);
            alunoController.adicionar(aluno);
        }
    }

    public void populateTurmaTable(int numeroDeEntradas) {
        for (int i = 0; i < numeroDeEntradas; i++) {
            TurmaRequest turma = new TurmaRequest();
            turma.setNome("Curso de " + faker.job().title());
            turma.setQuantidadeMaxima(faker.number().numberBetween(1, 30));
            turma.setDias(gerarDiasAleatorios());
            turma.setTurno(faker.options().option(TurnoEnum.values()));
            turmaController.adicionar(turma);
        }
    }

    private List<DiaEnum> gerarDiasAleatorios() {
        List<DiaEnum> diasSelecionados = new ArrayList<>();
        DiaEnum[] todosDias = DiaEnum.values();

        // Decide quantos dias aleatórios serão escolhidos (entre 1 e 7)
        int quantidadeDeDias = random.nextInt(todosDias.length) + 1;

        // Seleciona os dias aleatoriamente
        for (int i = 0; i < quantidadeDeDias; i++) {
            DiaEnum dia = todosDias[random.nextInt(todosDias.length)];
            if (!diasSelecionados.contains(dia)) {
                diasSelecionados.add(dia);
            }
        }
        return diasSelecionados;
    }

    public void populateDepartamentoTable(int numeroDeEntradas) {
        for (int i = 0; i < numeroDeEntradas; i++) {
            DepartamentoRequest departamento = new DepartamentoRequest();
            departamento.setNome(faker.educator().campus());
            departamentoController.adicionar(departamento);
        }
    }

    public void populateDisciplinaTable(int numeroDeEntradas) {
        for (int i = 0; i < numeroDeEntradas; i++) {
            DisciplinaRequest disciplina = new DisciplinaRequest();
            disciplina.setNome(faker.educator().course());
            disciplina.setCargaHoraria(Duration.ofHours(faker.number().numberBetween(1, 100)));
            disciplina.setDescricao(faker.shakespeare().hamletQuote());
            disciplina.setNumeroAlunos(faker.number().numberBetween(10, 25));
            disciplinaController.adicionar(disciplina);
        }
    }

    public void populateProfessorTable(int numeroDeEntradas) {
        for (int i = 0; i < numeroDeEntradas; i++) {
            ProfessorRequest professor = new ProfessorRequest();
            professor.setNome(faker.name().fullName());
            professor.setDataNascimento(gerarDataNascimento(30, 75));
            professor.setRg(faker.number().digits(9));
            professor.setOrgaoExpedidorRg(faker.space().agencyAbbreviation());
            professor.setCpf(gerarCPF(faker));
            professor.setSexo(faker.options().option(SexoEnum.values()));

            ContatoRequest contato = new ContatoRequest();
            contato.setTelefone(faker.phoneNumber().cellPhone());
            contato.setEmail(faker.internet().safeEmailAddress());
            professor.setContato(contato);

            EnderecoRequest endereco = new EnderecoRequest();
            endereco.setCep(faker.address().zipCode());
            endereco.setLogradouro(faker.address().streetName());
            endereco.setLogradouroNumero(faker.address().streetAddressNumber());
            endereco.setComplemento(faker.address().secondaryAddress());
            endereco.setBairro(faker.address().cityName());
            endereco.setCidade(faker.address().city());
            endereco.setEstado(faker.address().stateAbbr());
            professor.setEndereco(endereco);

            // Associar a um departamento aleatório se existir
            Long departamentoId = getRandomDepartamentoId();
            if (departamentoId != null) {
                professor.setDepartamentoId(departamentoId);
            }

            // Associar a disciplinas aleatórias se existirem
            List<Long> disciplinasIds = getRandomDisciplinasIds(1, 5);
            if (!disciplinasIds.isEmpty()) {
                professor.setDisciplinasId(disciplinasIds);
            }

            professorController.adicionar(professor);
        }
    }

    public void populateCursoTable(int numeroDeEntradas) {
        for (int i = 0; i < numeroDeEntradas; i++) {
            CursoRequest curso = new CursoRequest();
            curso.setNome(faker.educator().course());

            // Associar a um departamento aleatório se existir
            Long departamentoId = getRandomDepartamentoId();
            if (departamentoId != null) {
                curso.setDepartamentoId(departamentoId);
            }

            cursoController.adicionar(curso);
        }
    }

    // Métodos auxiliares para obter IDs aleatórios
    private Long getRandomDepartamentoId() {
        List<Long> ids = departamentoRepository.findAll().stream()
                .map(d -> d.getId())
                .toList();
        if (ids.isEmpty()) {
            return null;
        }
        return ids.get(random.nextInt(ids.size()));
    }

    private Long getRandomCursoId() {
        List<Long> ids = cursoRepository.findAll().stream()
                .map(c -> c.getId())
                .toList();
        if (ids.isEmpty()) {
            return null;
        }
        return ids.get(random.nextInt(ids.size()));
    }

    private Long getRandomTurmaId() {
        List<Long> ids = turmaRepository.findAll().stream()
                .map(t -> t.getId())
                .toList();
        if (ids.isEmpty()) {
            return null;
        }
        return ids.get(random.nextInt(ids.size()));
    }

    private Long getRandomAlunoId() {
        List<Long> ids = alunoRepository.findAll().stream()
                .map(a -> a.getId())
                .toList();
        if (ids.isEmpty()) {
            return null;
        }
        return ids.get(random.nextInt(ids.size()));
    }

    private List<Long> getRandomDisciplinasIds(int min, int max) {
        List<Long> allIds = disciplinaRepository.findAll().stream()
                .map(d -> d.getId())
                .toList();

        if (allIds.isEmpty()) {
            return new ArrayList<>();
        }

        int quantidade = random.nextInt(Math.min(max, allIds.size()) - min + 1) + min;
        List<Long> selectedIds = new ArrayList<>();
        List<Long> availableIds = new ArrayList<>(allIds);

        for (int i = 0; i < quantidade && !availableIds.isEmpty(); i++) {
            int index = random.nextInt(availableIds.size());
            selectedIds.add(availableIds.remove(index));
        }

        return selectedIds;
    }

}
