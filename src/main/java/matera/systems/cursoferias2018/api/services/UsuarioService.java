package matera.systems.cursoferias2018.api.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;

@Service
public class UsuarioService {

	private Map<UUID, UsuarioEntity> usuarios = new HashMap<>();
	
	public UsuarioService() {
		criaUsuarioResponse("geraldo", "Geraldo", "geraldo@gmail.com", "ADMINISTRADOR", null, UUID.randomUUID());
		criaUsuarioResponse("michelon", "Maicon", "maicon.f.michelon@gmail.com", "ADMINISTRADOR", null, UUID.randomUUID());
		criaUsuarioResponse("rochaPaulo", "Paulo Almeida", "paulo.almeida@matera.com", "ADMINISTRADOR", "https://s.gravatar.com/avatar/27b57f4f9580f95c4cbe78bb6d3ec893?s=80", UUID.randomUUID());
	}

	private void criaUsuarioResponse(String login, String nome, String email, String perfil, String urlPhoto, UUID uuid) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setEmail(email);
		usuarioEntity.setLogin(login);
		usuarioEntity.setNome(nome);
		usuarioEntity.setPerfil(perfil);
		usuarioEntity.setUrlPhoto(urlPhoto);
		usuarioEntity.setUuid(uuid);
		usuarios.put(uuid, usuarioEntity);
	}

	public Collection<UsuarioEntity> findAll() {
		return usuarios.values();
	}

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

	public UsuarioEntity findById(UUID id) {
		return usuarios.get(id);
	}

	public void salvar(UsuarioEntity usuarioEntity) {
		usuarios.put(UUID.randomUUID(), usuarioEntity);
	}

	public void delete(UUID id) {
		usuarios.remove(id);
	}
}
