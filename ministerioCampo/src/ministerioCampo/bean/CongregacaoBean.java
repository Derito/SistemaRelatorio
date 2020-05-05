package ministerioCampo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import ministerioCampo.dao.CongregacaoDAO;
import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dominio.Congregacao;
import ministerioCampo.dominio.Pais;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class CongregacaoBean implements Serializable{
	
	
	CongregacaoDAO conDAO = new CongregacaoDAO();
	
	PaisDAO paiDAO = new PaisDAO();
	
	private Congregacao congregacao;
	private List<Congregacao> congregacoes;
	private List<Pais> paises;
	
	public Congregacao getCongregacao() {
		return congregacao;
	}
	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}
	public List<Congregacao> getCongregacoes() {
		return congregacoes;
	}
	public void setCongregacoes(List<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}
	public List<Pais> getPaises() {
		return paises;
	}
	public void setEnderecos(List<Pais> paises) {
		this.paises = paises;
	}
	
	// Metodo listar
	@PostConstruct //chamado depois do construtor lista
		public void listar() {
			try {
				congregacoes= conDAO.listar();
				paises = paiDAO.listar();
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar listar as Congregações.");
				e.printStackTrace();
			}
		}
		public void novo() {
			try {
			
			congregacao = new Congregacao();
			paises = paiDAO.listar();
			congregacoes = conDAO.listar();
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar inserir uma nova Congregação.");
				e.printStackTrace();
			}
		}
		public void salvar() {
			try {
				
				conDAO.merge(congregacao);
				novo();// limpa a tela  + precisa redezenhar na tela
				//autualiza a tela
				congregacoes = conDAO.listar();
				paises = paiDAO.listar();
				//Usando OMNIFACE
				Messages.addGlobalInfo("Salvo com sucesso!");
				
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar salvar a Congregação.");
					e.printStackTrace();
				}
		}
		//o actionEvent pega da tela
			public void excluir(ActionEvent evento) {
			try {
				congregacao = (Congregacao) evento.getComponent().getAttributes().get("cidadeSeleccionada");
				
				conDAO.excluir(congregacao);
				
				//autualiza a tela
				paises = paiDAO.listar();
				congregacoes = conDAO.listar();
				
				Messages.addGlobalInfo(" Congregação excluida com sucesso!");
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar excluir a Congregação.");
				e.printStackTrace();
				}
			}
			public void editar(ActionEvent evento) {
				
				try {
					congregacao = (Congregacao) evento.getComponent().getAttributes().get("cidadeSeleccionada");
					
					congregacoes = conDAO.listar();
					paises = paiDAO.listar();
					}catch(RuntimeException e) {
						Messages.addGlobalInfo("Erro ao tentar editar a congregação.");
						e.printStackTrace();
					}
			}
	
	

}
