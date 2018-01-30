package matera.systems.cursoferias2018.api.domain.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FrequenciaEntity {
	
	private UsuarioEntity aluno;
	
	private DisciplinaEntity disciplina;

	private Set<Date> datas = new HashSet<>();
	
	public FrequenciaEntity(DisciplinaEntity disciplina, UsuarioEntity aluno) {
		this.disciplina = disciplina;
		this.aluno = aluno;
	}
	
	public FrequenciaEntity() {
	}

	public void adicionaData(Date data) {
		datas.add(data);
	}
	
	public void removeData(Date data) {
		datas.remove(data);
	}
	
	public UsuarioEntity getAluno() {
		return aluno;
	}

	public void setAluno(UsuarioEntity aluno) {
		this.aluno = aluno;
	}

	public Set<Date> getDatas() {
		return datas;
	}

	public DisciplinaEntity getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaEntity disciplina) {
		this.disciplina = disciplina;
	}

}
