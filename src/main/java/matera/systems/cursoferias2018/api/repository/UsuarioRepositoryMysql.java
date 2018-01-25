package matera.systems.cursoferias2018.api.repository;

import java.util.Collection;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

@Component()
@Profile("producao")
public class UsuarioRepositoryMysql implements UsuarioRepository {

	@Override
	public UUID salvar(UsuarioEntity usuarioEntity) {
		return null;
	}

	@Override
	public void delete(UUID id) {
	}

	@Override
	public UsuarioEntity findById(UUID id) {
		return null;
	}

	@Override
	public Collection<UsuarioEntity> findAll() {
		return null;
	}

}
