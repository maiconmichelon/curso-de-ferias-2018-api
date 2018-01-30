package matera.systems.cursoferias2018.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;

public interface DisciplinasRepository {

	List<DisciplinaEntity> listar();

	Optional<DisciplinaEntity> findById(UUID uuid);

	UUID salvar(DisciplinaEntity entity);

	void atualizar(DisciplinaEntity entity);

	void deletar(UUID uuid);
	
}
