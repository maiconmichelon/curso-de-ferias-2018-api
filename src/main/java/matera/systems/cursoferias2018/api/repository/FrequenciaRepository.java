package matera.systems.cursoferias2018.api.repository;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.entity.FrequenciaEntity;
import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

public interface FrequenciaRepository {

	FrequenciaEntity findOrCreateFrequencia(DisciplinaEntity disciplina, UsuarioEntity aluno);

}
