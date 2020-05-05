package ministerioCampo.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dominio.Pais;


/*
 * Usando CDI em substituição ao JSF
 */

@SuppressWarnings("serial")
@Named
@RequestScoped //Faz com que o tempo de vida  e vivo enquanto na respectiva tela
public class PaisBean implements Serializable{

	
	private Pais pais;
	private List<Pais> paises;
	 //Ao injectar CDI dispensa chamar em cada metodo.
	PaisDAO paiDAO = new PaisDAO();
		
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
		
	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	//Para conectar com a visao.
	@PostConstruct //chamado depois do construtor
	public void listar() {
		
		try {
			
			paises = paiDAO.listar();
			
		}catch(RuntimeException e) {
			Messages.addGlobalInfo("Erro ao tentar listar os paises.");
			e.printStackTrace();
		}
	}
	public void novo(){
		pais = new Pais();
	}
	//MODELOS DE COMUNICA;AO COM A VISAO
	public void salvar() {
	
	try {
	
		paiDAO.merge(pais);
		novo();// limpa a tela  + precisa redezenhar na tela
		//autualiza a tela
		paises = paiDAO.listar();
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
		pais = (Pais) evento.getComponent().getAttributes().get("paisSeleccionado");
		
		paiDAO.excluir(pais);
		//autualiza a tela
		paises = paiDAO.listar();
		
		Messages.addGlobalInfo(" Pais excluido com sucesso!");
	}catch(RuntimeException e) {
		Messages.addGlobalError("Erro ao tentar excluir o pais.");
		e.printStackTrace();
		}
	}
	public void editar(ActionEvent evento) {
	
		try {
			pais = (Pais) evento.getComponent().getAttributes().get("paisSeleccionado");
		
		}catch(RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar editar um Pais.");
			e.printStackTrace();
		}
	}
}
