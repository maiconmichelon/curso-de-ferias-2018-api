package matera.systems.cursoferias2018.api.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

@Component
@Profile("integration-test")
public class UsuarioRepositoryStub implements UsuarioRepository {

	private Map<UUID, UsuarioEntity> usuarios = new HashMap<>();
	
	public UsuarioRepositoryStub() {
		criaUsuarioResponse("geraldo", "Geraldo", "geraldo@gmail.com", "ADMINISTRADOR", null, UUID.randomUUID());
		criaUsuarioResponse("michelon", "Maicon", "maicon.f.michelon@gmail.com", "ADMINISTRADOR", null, UUID.fromString("369d8a35-e1df-4afc-9e0e-146b44f27d6d"));
		criaUsuarioResponse("rochapaulo", "Paulo Almeida", "paulo.almeida@matera.com", "ADMINISTRADOR", 
				"https://s.gravatar.com/avatar/27b57f4f9580f95c4cbe78bb6d3ec893?s=80", 
				UUID.fromString("bc51c8bb-bad3-47e4-af0c-7f467148f23d"));
	}
	
	@Override
	public UUID salvar(UsuarioEntity usuarioEntity) {
		return UUID.randomUUID();
	}
	
	@Override
	public void delete(UUID id) {
	}

	@Override
	public UsuarioEntity findById(UUID id) {
		return usuarios.get(id);
	}

	@Override
	public Collection<UsuarioEntity> findAll() {
		return usuarios.values();
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

}
