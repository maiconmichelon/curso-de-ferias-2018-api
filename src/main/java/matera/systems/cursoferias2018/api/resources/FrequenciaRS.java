package matera.systems.cursoferias2018.api.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.entity.FrequenciaEntity;
import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import matera.systems.cursoferias2018.api.repository.DisciplinaRepository;
import matera.systems.cursoferias2018.api.repository.FrequenciaRepository;
import matera.systems.cursoferias2018.api.repository.UsuarioRepository;
import matera.systems.cursoferias2018.api.services.FrequenciaService;

@RestController
@RequestMapping(path = "/frequencia")
public class FrequenciaRS {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private FrequenciaRepository frequenciaRepository;
	
	@Autowired
	private FrequenciaService frequenciaService;
	
	@PutMapping(path = "/{idDisciplina}/{idUsuario}")
	public ResponseEntity<Void> adicionaPresenca(@PathVariable String idDisciplina, @PathVariable String idUsuario, @RequestParam(required = false) String data) throws Exception {
		Optional<DisciplinaEntity> disciplina = disciplinaRepository.findByID(UUID.fromString(idDisciplina));
		Optional<UsuarioEntity> usuario = usuarioRepository.findByID(UUID.fromString(idUsuario));
		if (!usuario.isPresent() || !disciplina.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		FrequenciaEntity frequencia = frequenciaRepository.findOrCreateFrequencia(disciplina.get(), usuario.get());
		frequenciaService.adicionaFrenquencia(frequencia, readDataFromString(data));
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{idDisciplina}/{idUsuario}")
	public ResponseEntity<Void> deletaPresenca(@PathVariable String idDisciplina, @PathVariable String idUsuario, @RequestParam(required = false) String data) throws Exception {
		Optional<DisciplinaEntity> disciplina = disciplinaRepository.findByID(UUID.fromString(idDisciplina));
		Optional<UsuarioEntity> usuario = usuarioRepository.findByID(UUID.fromString(idUsuario));
		if (!usuario.isPresent() || !disciplina.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		FrequenciaEntity frequencia = frequenciaRepository.findOrCreateFrequencia(disciplina.get(), usuario.get());
		frequenciaService.deletaPresenca(frequencia, readDataFromString(data));
		return ResponseEntity.noContent().build();
	}

	private Date readDataFromString(String data) throws Exception {
		return new SimpleDateFormat("YYYY-MM-DD").parse(data);
	}
	
}
