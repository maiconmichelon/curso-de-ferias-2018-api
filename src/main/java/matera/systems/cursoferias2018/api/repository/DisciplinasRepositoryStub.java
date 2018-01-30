package matera.systems.cursoferias2018.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;

@Service
@Profile("stub")
public class DisciplinasRepositoryStub implements DisciplinasRepository {

    public static final UUID DISCIPLINA_2 = UUID.fromString("4a8975d1-9e37-4872-bd35-1340705384f8");
    public static final UUID DISCIPLINA_3 = UUID.fromString("4a6735d1-9e34-4811-bd35-1347875384f8");
	
	private static final Map<UUID, DisciplinaEntity> map = new HashMap<>();
	
	static {
		{
			DisciplinaEntity entity = new DisciplinaEntity();
			entity.setDataInicio("01/01/2018");
			entity.setDataTermino("01/01/2019");
			entity.setDescricao("Matemática");
			entity.setSegmento("Segmento");
			entity.setUrlLogo("wololo");
			entity.setUuid(UUID.randomUUID());
			map.put(entity.getUuid(), entity);
		}
		{
			DisciplinaEntity entity = new DisciplinaEntity();
			entity.setDataInicio("01/01/2018");
			entity.setDataTermino("01/01/2019");
			entity.setDescricao("Portugues");
			entity.setSegmento("Segmento");
			entity.setUrlLogo("wololo");
			entity.setUuid(DISCIPLINA_2);
			map.put(entity.getUuid(), entity);
		}
		{
			DisciplinaEntity entity = new DisciplinaEntity();
			entity.setDataInicio("01/01/2018");
			entity.setDataTermino("01/01/2019");
			entity.setDescricao("Quimica");
			entity.setSegmento("Segmento");
			entity.setUrlLogo("wololo");
			entity.setUuid(DISCIPLINA_3);
			map.put(entity.getUuid(), entity);
		}
	}
	
	@Override
	public List<DisciplinaEntity> listar() {
		return new ArrayList<>(map.values());
	}
	
	@Override
	public Optional<DisciplinaEntity> findById(UUID uuid) {
		return Optional.ofNullable(map.getOrDefault(uuid, null));
	}

	@Override
	public UUID salvar(DisciplinaEntity entity) {
		entity.setUuid(UUID.randomUUID());
		map.put(entity.getUuid(), entity);
		return entity.getUuid();
	}

	@Override
	public void atualizar(DisciplinaEntity entity) {
		map.put(entity.getUuid(), entity);
	}

	@Override
	public void deletar(UUID uuid) {
		map.remove(uuid);
	}

}
