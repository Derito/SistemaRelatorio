package ministerioCampo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Anciao extends Generico{
	

	@Column(name = "col_responsabi", length = 20, nullable = false)
	private String responsabilidade;
	
	@ManyToOne
	@JoinColumn(name = "col_anc_pessoa", nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "col_anc_publicador", nullable = false)
	private Publicador publicador;
	
	@ManyToOne
	@JoinColumn(name = "col_anc_congreg", nullable = false)
	private Congregacao congregacao;
		
	public String getResponsabilidade() {
		return responsabilidade;
	}
	public void setResponsabilidade(String responsabilidade) {
		this.responsabilidade = responsabilidade;
	}
	public Publicador getPublicador() {
		return publicador;
	}
	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Congregacao getCongregacao() {
		return congregacao;
	}
	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}
	
}
