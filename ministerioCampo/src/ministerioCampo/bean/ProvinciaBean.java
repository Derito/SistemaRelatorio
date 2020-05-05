package ministerioCampo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import ministerioCampo.dao.ProvinciaDAO;
import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dominio.Pais;
import ministerioCampo.dominio.Provincia;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class ProvinciaBean implements Serializable{
	
	
	ProvinciaDAO proDAO = new ProvinciaDAO();
	
	PaisDAO paiDAO = new PaisDAO();
	
	private Provincia provincia;
	private List<Provincia> provincias;
	private List<Pais>paises;
	
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public List<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincias(List<Provincia> provincias) {
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
		provincias = proDAO.listar();
		paises = paiDAO.listar();
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar listar os Endereços");
				e.printStackTrace();
			}
		}
		public void novo() {
			try {
				provincia = new Provincia();
				provincias = proDAO.listar();
				paises = paiDAO.listar();
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar inserir um novo Endereço");
				e.printStackTrace();
			}
		}
		public void salvar() {
			try {
				
				proDAO.merge(provincia);
				novo();// limpa a tela  + precisa redezenhar na tela
				//autualiza a tela
				provincias = proDAO.listar();
				paises = paiDAO.listar();
				//Usando OMNIFACE
				Messages.addGlobalInfo("Salvo com sucesso!");
				
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar salvar um Endereço");
					e.printStackTrace();
				}
		}
		//o actionEvent pega da tela
			public void excluir(ActionEvent evento) {
			try {
				provincia = (Provincia) evento.getComponent().getAttributes().get("provinciaSeleccionada");
				
				proDAO.excluir(provincia);
				//autualiza a tela
				paises = paiDAO.listar();
				provincias = proDAO.listar();
				
				Messages.addGlobalInfo("Provincia excluido com sucesso!");
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar excluir a Provincia");
				e.printStackTrace();
				}
		}
			public void editar(ActionEvent evento) {
				
				try {
					provincia = (Provincia) evento.getComponent().getAttributes().get("provinciaSeleccionada");
					provincias = proDAO.listar();
					paises = paiDAO.listar();
					}catch(RuntimeException e) {
						Messages.addGlobalInfo("Erro ao tentar editar a Provincia.");
						e.printStackTrace();
					}
			}
	
}
