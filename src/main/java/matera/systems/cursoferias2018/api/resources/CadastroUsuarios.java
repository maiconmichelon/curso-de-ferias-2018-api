package matera.systems.cursoferias2018.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import matera.systems.cursoferias2018.api.domain.request.UsuarioRequest;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.services.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class CadastroUsuarios {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<Collection<UsuarioResponse>> listaUsuarios() {
		final List<UsuarioResponse> response = new ArrayList<>();
		final Collection<UsuarioEntity> usuarios = usuarioService.findAll();
		for (UsuarioEntity usuarioEntity : usuarios) {
			response.add(usuarioService.usuarioEntityToResponse(usuarioEntity));
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<UsuarioResponse> listaUsuario(@PathVariable String id, @RequestBody UsuarioRequest usuarioRequest) {
		final UsuarioEntity usuario = usuarioService.findById(UUID.fromString(id));
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		final UsuarioResponse response = usuarioService.usuarioEntityToResponse(usuario);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> atualiza(@PathVariable String id) {
		// TODO
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(consumes = { "application/json" })
	public ResponseEntity<Void> novoUsuario(UsuarioRequest request) throws URISyntaxException {
		final UsuarioEntity usuarioEntity = request.toUsuarioEntity();
		
		usuarioService.salvar(usuarioEntity);
		
		final URI uri = new URI("/usuarios/" + usuarioEntity.getUuid().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		usuarioService.delete(UUID.fromString(id));
		return ResponseEntity.noContent().build();
	}
	
}
