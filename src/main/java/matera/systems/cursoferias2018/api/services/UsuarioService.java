package matera.systems.cursoferias2018.api.services;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public UsuarioResponse usuarioEntityToResponse(UsuarioEntity usuarioEntity) {
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		usuarioResponse.setEmail(usuarioEntity.getEmail());
		usuarioResponse.setLogin(usuarioEntity.getLogin());
		usuarioResponse.setNome(usuarioEntity.getNome());
		usuarioResponse.setPerfil(usuarioEntity.getPerfil());
		usuarioResponse.setUrlPhoto(usuarioEntity.getUrlPhoto());
		usuarioResponse.setUuid(usuarioEntity.getUuid());
		
		return usuarioResponse;
	}

	public Collection<UsuarioEntity> findAll() {
		return repository.findAll();
	}
	
	public UsuarioEntity findById(UUID id) {
		return repository.findById(id);
	}

	public void salvar(UsuarioEntity usuarioEntity) {
		repository.salvar(usuarioEntity);
	}

	public void delete(UUID id) {
		repository.delete(id);
	}
}
