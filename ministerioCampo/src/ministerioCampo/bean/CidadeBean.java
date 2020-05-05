package ministerioCampo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import ministerioCampo.dao.CidadeDAO;
import ministerioCampo.dao.ProvinciaDAO;
import ministerioCampo.dominio.Cidade;
import ministerioCampo.dominio.Pais;
import ministerioCampo.dominio.Provincia;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class CidadeBean implements Serializable {
	
	
	CidadeDAO cidDAO = new CidadeDAO();
	
	ProvinciaDAO proDAO = new ProvinciaDAO();
	
	private Cidade cidade;
	private List<Cidade> cidades;
	
	private List<Provincia> provincias;
	
	private List<Pais> paises;
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public List<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincia(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	public List<Pais> getPaises() {
		return paises;
	}
	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	// Metodo listar
	@PostConstruct //chamado depois do construtor lista
	public void listar() {
		try {
			cidades= cidDAO.listar();
			provincias = proDAO.listar();
			
		}catch(RuntimeException e) {
			Messages.addGlobalInfo("Erro ao tentar listar as cidades.");
			e.printStackTrace();
		}
	}
	public void novo() {
		try {
		cidade = new Cidade();
		provincias = proDAO.listar();
		}catch(RuntimeException e) {
			Messages.addGlobalInfo("Erro ao tentar criar uma nova cidade.");
			e.printStackTrace();
		}
	}
	public void salvar() {
		try {
			
			cidDAO.merge(cidade);
			novo();// limpa a tela  + precisa redezenhar na tela
			
			//autualiza a tela
			cidades = cidDAO.listar();
			provincias = proDAO.listar();
			//Usando OMNIFACE
			Messages.addGlobalInfo("Salvo com sucesso!");
			
		}catch(RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar salvar o pais.");
				e.printStackTrace();
			}
	}
	//o actionEvent pega da tela
		public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSeleccionada");
			
			cidDAO.excluir(cidade);
			//autualiza a tela
			//provincias = proDAO.listar();
			cidades = cidDAO.listar();
			
			Messages.addGlobalInfo(" Cidade excluida com sucesso!");
		}catch(RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar excluir a cidade.");
			e.printStackTrace();
			}
		}
		public void editar(ActionEvent evento) {
			
			try {
				cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSeleccionada");
				//cidades = cidDAO.listar();
				//provincias = proDAO.listar();
				}catch(RuntimeException e) {
					Messages.addGlobalInfo("Erro ao tentar editar a cidade.");
					e.printStackTrace();
				}
		}

}
