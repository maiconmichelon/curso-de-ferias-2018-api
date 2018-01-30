package matera.systems.cursoferias2018.api.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.entity.FrequenciaEntity;
import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

@Service
public class FrequenciaRepositoryStub implements FrequenciaRepository {
	
	private Map<org.springframework.data.util.Pair<UUID, UUID>, FrequenciaEntity> map = new HashMap<>();

	@Override
	public FrequenciaEntity findOrCreateFrequencia(DisciplinaEntity disciplina, UsuarioEntity aluno) {
		Pair<UUID,UUID> key = buildKey(disciplina, aluno);
		FrequenciaEntity frequencia = map.get(key);
		
		if (frequencia == null) {
			frequencia = new FrequenciaEntity(disciplina, aluno);
			map.put(key, frequencia);
		}
		
		return frequencia;
	}
	
	private Pair<UUID,UUID> buildKey(DisciplinaEntity disciplina, UsuarioEntity aluno) {
		return Pair.of(disciplina.getId(), aluno.getUuid());
	}
	
}
