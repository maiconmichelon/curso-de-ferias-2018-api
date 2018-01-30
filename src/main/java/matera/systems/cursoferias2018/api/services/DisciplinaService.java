package matera.systems.cursoferias2018.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.request.AtualizarDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.request.CriaDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.response.DisciplinaResponse;
import matera.systems.cursoferias2018.api.repository.DisciplinasRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinasRepository repository;
	
	public List<DisciplinaResponse> listar() {
		return repository.listar().parallelStream().map(toResponse).collect(Collectors.toList());
	}
	
	public Optional<DisciplinaResponse> findById(UUID uuid) {
		return repository.findById(uuid).map(toResponse);
	}

	public UUID criar(CriaDisciplinaRequest request) {
		DisciplinaEntity entity = new DisciplinaEntity();
		entity.setDataInicio(request.getDataInicio());
		entity.setDataTermino(request.getDataTermino());
		entity.setDescricao(request.getDescricao());
		entity.setSegmento(request.getSegmento());
		entity.setUrlLogo(request.getUrlLogo());
		return repository.salvar(entity);
	}
	
	private Function<DisciplinaEntity, DisciplinaResponse> toResponse = (entity) -> {
		DisciplinaResponse response = new DisciplinaResponse();
		response.setDataInicio(entity.getDataInicio());
		response.setDataTermino(entity.getDataTermino());
		response.setDescricao(entity.getDescricao());
		response.setSegmento(entity.getSegmento());
		response.setUrlLogo(entity.getUrlLogo());
		response.setUuid(entity.getUuid());
		return response;
	};

	public void atualizar(UUID uuid, AtualizarDisciplinaRequest requestBody) {
		Optional<DisciplinaEntity> entity = repository.findById(uuid);
		if (entity.isPresent()) {
			DisciplinaEntity disciplina = entity.get();
			disciplina.setDescricao(requestBody.getDescricao());
			repository.atualizar(disciplina);
			return;
		}
		
		throw new IllegalArgumentException("Id da disciplina não foi encontrado");
	}

	public void deletar(UUID uuid) {
		repository.deletar(uuid);
	}

}
