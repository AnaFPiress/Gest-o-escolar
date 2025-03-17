import java.io.Serializable;
import java.util.ArrayList;

public class Turma implements Serializable {
 private int numeroTurma;
 private ArrayList<Aluno> Alunos =  new  ArrayList<Aluno> ();
 private ArrayList<HoraSemana> Horario = new  ArrayList<HoraSemana> ();
 private ArrayList <Disciplina> Disciplinas = new  ArrayList<Disciplina> ();
 private ArrayList <Professores> Professores = new  ArrayList<Professores> ();
 
 	//Criacao de uma turma 
 	public Turma (int numeroTurma ,ArrayList<Aluno> al , ArrayList <Disciplina> discp , ArrayList <Professores> prof ) {
 		int i = 0;
 		this.numeroTurma = numeroTurma;
 		Alunos = al;
 		Disciplinas = discp;
 		Professores = prof;
 		//Juntar ao horario a hora das aulas de cada disciplina
 		for (i = 0 ; i < discp.size() ; i++ ) {
 			Horario.addAll(discp.get(i).getHoraAulas());
 		}
 	}

 	//Getters e Setters
	public ArrayList<Aluno> getAlunos() {
		return Alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		Alunos = alunos;
	}

	public ArrayList<HoraSemana> getHorario() {
		return Horario;
	}

	public int getNumeroTurma() {
		return numeroTurma;
	}

	public void setNumeroTurma(int numeroTurma) {
		this.numeroTurma = numeroTurma;
	}

	public void setHorario(ArrayList<HoraSemana> horario) {
		Horario = horario;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return Disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		Disciplinas = disciplinas;
	}

	public ArrayList<Professores> getProfessores() {
		return Professores;
	}

	public void setProfessores(ArrayList<Professores> professores) {
		Professores = professores;
	}

	@Override
	public String toString() {
		return "Turma Numero: " + numeroTurma + " Alunos: " + Alunos + " Disciplinas:"
				+ Disciplinas + " Professores:" + Professores;
	}
}
