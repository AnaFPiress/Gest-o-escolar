import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Disciplina implements Serializable {
	private int id;
	private String nomeDiscp;
	private ArrayList<HoraSemana> HoraAulas = new  ArrayList<HoraSemana> ();
	
	public Disciplina (int id , String nome, HoraSemana aula) {
		nomeDiscp = nome;
		this.id = id;
		HoraAulas.add(aula);
	}

	public String getNomeDiscp() {
		return nomeDiscp;
	}

	public void setNomeDiscp(String nomeDiscp) {
		this.nomeDiscp = nomeDiscp;
	}

	public ArrayList<HoraSemana> getHoraAulas() {
		return HoraAulas;
	}

	public void setHoraAulas(ArrayList<HoraSemana> horaAulas) {
		HoraAulas = horaAulas;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Disciplina: " + nomeDiscp+ ", Hora das Aulas = " + HoraAulas ;
	}
	
	@Override
	public boolean equals(Object o) {
		if ( o != null && o.getClass() == this.getClass()) {
			Disciplina discp = (Disciplina) o;
			if(this.nomeDiscp == discp.nomeDiscp && this.HoraAulas == discp.HoraAulas && this.id == discp.id) {
				return true;
			}
			else return false;
		}
		else return false;
	}
	
}
