package ministerioCampo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import ministerioCampo.dao.CongregacaoDAO;
import ministerioCampo.dao.PessoaDAO;
import ministerioCampo.dao.PublicadorDAO;
import ministerioCampo.dominio.Congregacao;
import ministerioCampo.dominio.Pessoa;
import ministerioCampo.dominio.Publicador;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class PublicadorBean implements Serializable {
	
	
	PublicadorDAO pubDAO = new PublicadorDAO();
	
	PessoaDAO pesDAO = new PessoaDAO();
	
	CongregacaoDAO conDAO = new CongregacaoDAO();
	
	private Publicador publicador;
	private List<Publicador> publicadores;
	private List<Pessoa> pessoas;
	private List<Congregacao> congregacoes;
	
	public Publicador getPublicador() {
		return publicador;
	}
	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}
	public List<Publicador> getPublicadores() {
		return publicadores;
	}
	public void setPublicadores(List<Publicador> publicadores) {
		this.publicadores = publicadores;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public List<Congregacao> getCongregacoes() {
		return congregacoes;
	}
	public void setCongregacoes(List<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}
	
	// Metodo listar
	@PostConstruct //chamado depois do construtor lista
		public void listar() {
			try {
				publicadores= pubDAO.listar();
				congregacoes = conDAO.listar();
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar listar os publicadores.");
				e.printStackTrace();
			}
		}
		public void novo() {
			try {
			publicador = new Publicador();
			publicadores = pubDAO.listar();
			congregacoes = conDAO.listar();
			pessoas = pesDAO.listar();
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar  os publicadores.");
				e.printStackTrace();
			}
		}
		public void salvar() {
			try {
				
				pubDAO.merge(publicador);
				novo();// limpa a tela  + precisa redezenhar na tela
				//autualiza a tela
				publicadores = pubDAO.listar();
				pessoas = pesDAO.listar();
				congregacoes = conDAO.listar();
				//Usando OMNIFACE
				Messages.addGlobalInfo("Salvo com sucesso!");
				
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar salvar o Publicador.");
					e.printStackTrace();
				}
		}
		//o actionEvent pega da tela
			public void excluir(ActionEvent evento) {
			try {
				publicador = (Publicador) evento.getComponent().getAttributes().get("cidadeSeleccionada");
				
				pubDAO.excluir(publicador);
				//autualiza a tela
				pessoas = pesDAO.listar();
				publicadores = pubDAO.listar();
				
				Messages.addGlobalInfo(" Publicador excluido com sucesso!");
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar excluir o Publicador.");
				e.printStackTrace();
				}
			}
			public void editar(ActionEvent evento) {
				
				try {
					publicador = (Publicador) evento.getComponent().getAttributes().get("cidadeSeleccionada");
					
					publicadores = pubDAO.listar();
					congregacoes = conDAO.listar();
					pessoas = pesDAO.listar();
					}catch(RuntimeException e) {
						Messages.addGlobalInfo("Erro ao tentar editar a congregação.");
						e.printStackTrace();
					}
			}
	

}
