package ministerioCampo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity()
public class Pessoa extends Generico {

	
	@Column(name = "col_pesNome", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "col_bi", length = 15, nullable = false)
	private String bi;
	
	@Column(name = "col_rua", length = 100, nullable = false)
	private String rua;
	
	@Column(name = "col_numero", nullable = false)
	private Short numero;
	
	@Column(name = "col_emal", length = 100, nullable = false)
	private String email;
	
	@Column(name = "col_telefone", length = 13)
	private String telefone;
	
	@Column(name = "col_celular", length = 14, nullable = false)
	private String celular;
	
	@Column(name = "col_complemento", length = 10, nullable = false)
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name = "col_pes_cidade", nullable = false)
	private Cidade cidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBi() {
		return bi;
	}
	public void setBi(String bi) {
		this.bi = bi;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Short getNumero() {
		return numero;
	}
	public void setNumero(Short numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
