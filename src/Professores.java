import java.io.Serializable;
import java.time.LocalDate;

public class Professores implements Serializable {
    private int id;
    private String nome = "";
    private LocalDate DataNas;
    private String localidade = "";

    //Funcao criacao de professores
    public Professores (int i, String n , LocalDate datNas, String local){
        id= i;
        nome = n;
        DataNas = datNas;
        localidade = local;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getIdade() {
        return DataNas;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(LocalDate DataNas) {
        this.DataNas = DataNas;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    
    @Override
	public String toString() {
		return "Professor: " + id + ", Nome: " + nome + ", Data de Nascimento: " + DataNas + ", Localidade: " + localidade + "\n";
	}
}