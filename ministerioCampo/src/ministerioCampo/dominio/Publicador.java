package ministerioCampo.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Publicador extends Generico {
	
		
	@Column(name = "col_baptizado", length = 4, nullable = false)
	private boolean baptizado;
	
	@Column(name = "col_databaptismo", length = 4)
	@Temporal(TemporalType.DATE)
	private Date dataBaptismo;
	
	@Column(name = "col_datapublicador", length = 4, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date iniPublicador;

	@ManyToOne
	@JoinColumn(name = "col_publ_congregacao", nullable = false)
	private Congregacao congregacao;
	
	@ManyToOne
	@JoinColumn(name = "col_publ_pessoa", nullable = false)
	private Pessoa pessoa;
		
	public boolean isBaptizado() {
		return baptizado;
	}
	public void setBaptizado(boolean baptizado) {
		this.baptizado = baptizado;
	}
	public Date getDataBaptismo() {
		return dataBaptismo;
	}
	public void setDataBaptismo(Date dataBaptismo) {
		this.dataBaptismo = dataBaptismo;
	}
	public Date getIniPublicador() {
		return iniPublicador;
	}
	public void setIniPublicador(Date iniPublicador) {
		this.iniPublicador = iniPublicador;
	}
	public Congregacao getCongregacao() {
		return congregacao;
	}
	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
