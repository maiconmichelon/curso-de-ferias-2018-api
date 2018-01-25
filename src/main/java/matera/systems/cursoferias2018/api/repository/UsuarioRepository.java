package matera.systems.cursoferias2018.api.repository;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Component;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

@Component
public interface UsuarioRepository {

	UUID salvar(UsuarioEntity usuarioEntity);

	void delete(UUID id);
	
	UsuarioEntity findById(UUID id);
	
	Collection<UsuarioEntity> findAll();
	
}
