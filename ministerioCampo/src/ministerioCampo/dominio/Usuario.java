package ministerioCampo.dominio;

import java.lang.Character;
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends Generico {

	
	@Column(name = "col_senha", length = 32, nullable = false)
	private String senha;
	
	@Transient // Informa que não é um campo do banco dados mais é parte da persistencia
	private String senhaSemCriptografia;
	
	@Column(name = "col_tipo", length = 3, nullable = false)
	private Character tipo;	
	
	@Column(length = 3,  nullable = false)
	private boolean activo;
	
	@OneToOne
	@JoinColumn(name = "col_uso_pessoa", nullable = false)
	private Pessoa pessoa;
	
	   
	public String getSenha() {
 		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}
	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}
	   
	public Character getTipo() {
 		return this.tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
	
	//Conversção para String do tipo character
	@Transient //informa que não e um campo do banco
	public String getTipoFormatado() {
		String tipoFormatado = null;
		
		if(tipo == 'A') {
			tipoFormatado = "Administrador";
		}else if (tipo == 'S') {
			tipoFormatado = "Secretário";
		}else if (tipo == 'P') {
			tipoFormatado = "Publicador";
		}
		return tipoFormatado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Transient
	public String getActivoFormatado() {
		String activoFormatado = null;
		
		if(activo) {
			activoFormatado ="Sim";
		}else {
			activoFormatado ="Não";
		}
		return activoFormatado;
	}

   
}
