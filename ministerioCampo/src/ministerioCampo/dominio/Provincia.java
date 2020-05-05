package ministerioCampo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Provincia extends Generico{

	@Column(name = "col_nomeProvincia", length = 20, nullable = false)
	private String nomeProvincia;
	
	@Column(name = "col_siglaProvincia", length = 3, nullable = false)
	private String siglaProvincia;
	
	@ManyToOne
	@JoinColumn(name = "col_prov_pais", nullable = false)
	private Pais pais;

	public String getNomeProvincia() {
		return nomeProvincia;
	}

	public void setNomeProvincia(String nomeProvincia) {
		this.nomeProvincia = nomeProvincia;
	}

	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
