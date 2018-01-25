package matera.systems.cursoferias2018.api.domain.request;

import java.util.UUID;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

public class UsuarioRequest {

	private String nome;
	
	private String login;
	
	private String email;
	
	private String perfil;
	
	private String urlPhoto;

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public UsuarioEntity toUsuarioEntity() {
		final UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setNome(getNome());
		usuarioEntity.setEmail(getEmail());
		usuarioEntity.setLogin(getLogin());
		usuarioEntity.setPerfil(getPerfil());
		usuarioEntity.setUrlPhoto(getUrlPhoto());
		usuarioEntity.setUuid(UUID.randomUUID());
		
		return usuarioEntity;
	}
	
}
