package matera.systems.cursoferias2018.api.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.FrequenciaEntity;

@Service
public class FrequenciaService {
	
	public void adicionaFrenquencia(FrequenciaEntity frequencia, Date data) {
		frequencia.adicionaData(data);
	}
	
	public void deletaPresenca(FrequenciaEntity frequencia, Date data) {
		frequencia.removeData(data);
	}
	
}
