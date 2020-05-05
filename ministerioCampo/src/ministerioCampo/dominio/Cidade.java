package ministerioCampo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class Cidade extends Generico {
	
	
	@Column(name = "col_nomeCidade", length = 50, nullable = false)
	private String nomeCidade;
	
	@Column(name = "col_sigla", length = 3, nullable = false)
	private String sigla;
	
	@ManyToOne
	@JoinColumn(name = "col_cid_provin", nullable = false)
	private Provincia provincia;
			
	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
}
