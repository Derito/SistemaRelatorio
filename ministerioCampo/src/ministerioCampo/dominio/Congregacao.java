package ministerioCampo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Congregacao extends Generico {
	
	
	@Column(name = "col_nome", length = 50, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "col_congr_pais", nullable = false)
	private Pais pais;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
