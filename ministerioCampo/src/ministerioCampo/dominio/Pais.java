package ministerioCampo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Pais extends Generico {

	
	@Column(name = "col_nomeP", length = 50, nullable = false)
	private String nomePais;
	
	@Column(name = "col_sigla", length = 3, nullable = false)
	private String  sigla;
	
	
	public String getNomePais() {
		return nomePais;
	}
	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
