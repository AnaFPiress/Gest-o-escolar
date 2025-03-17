import java.io.Serializable;

public class HoraSemana implements Serializable {
	private String dia;
	private int horaInicio;
	private int minutoInicio;
	private int horaFim;
	private int minutoFim;
	
	public HoraSemana (String d, int hi, int mi , int hf , int mf){
		dia = d;
		horaInicio = hi;
		minutoInicio = mi;
		horaFim = hf;
		minutoFim = mf;		
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getMinutoInicio() {
		return minutoInicio;
	}

	public void setMinutoInicio(int minutoInicio) {
		this.minutoInicio = minutoInicio;
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}

	public int getMinutoFim() {
		return minutoFim;
	}

	public void setMinutoFim(int minutoFim) {
		this.minutoFim = minutoFim;
	}

	@Override
	public String toString() {
		return "Dia: " + dia + " \n Começa= " + horaInicio + " : " + minutoInicio + "\n Acaba= "
				+ horaFim + " : " + minutoFim ;
	}
	
	@Override
	public boolean equals(Object o) {
		if ( o != null && o.getClass() == this.getClass()) {
			HoraSemana hora = (HoraSemana) o;
			if(this.horaInicio == hora.horaInicio && this.minutoInicio == hora.minutoInicio && this.horaFim == hora.horaFim && this.minutoFim == hora.minutoFim && dia.equals(hora.dia) ) {
				return true;
			}
			else return false;
		}
		else return false;
	}
}
