package matera.systems.cursoferias2018.api.resources;

import static org.springframework.http.HttpStatus.OK;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
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

import matera.systems.cursoferias2018.api.domain.request.AtualizarDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.request.CriaDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.response.DisciplinaResponse;
import matera.systems.cursoferias2018.api.services.DisciplinaService;

@RestController
@RequestMapping(path = "/disciplinas")
public class DisciplinasRS {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping
	public ResponseEntity<List<DisciplinaResponse>> buscaDisciplinas() {
		return ResponseEntity.status(OK).body(disciplinaService.listar());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<DisciplinaResponse> buscaDisciplina(@PathVariable String id) {
		Optional<DisciplinaResponse> response = disciplinaService.findById(UUID.fromString(id));
		if (response.isPresent()) {
			return ResponseEntity.status(OK).body(response.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Void> cria(@RequestBody CriaDisciplinaRequest request) throws URISyntaxException {
		UUID uuid = disciplinaService.criar(request);
		return ResponseEntity.created(new URI("/disciplinas/" + uuid.toString())).build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> altera(@PathVariable String id, @RequestBody AtualizarDisciplinaRequest requestBody) {
		UUID uuid = UUID.fromString(id);
		try {
			disciplinaService.atualizar(uuid, requestBody);
			return ResponseEntity.ok().build();
		} catch(IllegalArgumentException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> remove(@PathVariable String id) {
		UUID uuid = UUID.fromString(id);
		try {
			disciplinaService.deletar(uuid);
			return ResponseEntity.noContent().build();
		} catch(IllegalArgumentException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
