package ministerioCampo.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ministerioCampo.dominio.Anciao;
import ministerioCampo.dominio.Congregacao;
import ministerioCampo.dominio.Pessoa;


@SuppressWarnings({ "serial" })
@Named
@RequestScoped
public class AnciaoBean implements Serializable{

	private List<Pessoa> pessoas;
	
	private Anciao anciao;
	
	private List<Anciao> anciaos;
	private List<Congregacao> congregacoes;
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public Anciao getAnciao() {
		return anciao;
	}
	public void setAnciao(Anciao anciao) {
		this.anciao = anciao;
	}
	public List<Anciao> getAnciaos() {
		return anciaos;
	}
	public void setAnciaos(List<Anciao> anciaos) {
		this.anciaos = anciaos;
	}
	public List<Congregacao> getCongregacoes() {
		return congregacoes;
	}
	public void setCongregacoes(List<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}
	
	
}
