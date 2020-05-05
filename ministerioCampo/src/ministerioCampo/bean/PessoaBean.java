package ministerioCampo.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.omnifaces.util.Messages;

import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dao.PessoaDAO;
import ministerioCampo.dominio.Cidade;
import ministerioCampo.dominio.Pais;
import ministerioCampo.dominio.Pessoa;
import ministerioCampo.dominio.Provincia;


@SuppressWarnings({ "serial" })
@Named
@RequestScoped
public class PessoaBean implements Serializable{
	
	
	PessoaDAO pesDAO = new PessoaDAO();
	
	PaisDAO paiDAO = new PaisDAO();
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	private Pais pais;
	private List<Pais> paises;
	
	private List<Provincia> provincias;
	
	private List<Cidade> cidades;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
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

	public List<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
		//Para conectar com a visao.
		@PostConstruct //chamado depois do construtor
	public void listar() {
			
		try {
			pessoas = pesDAO.listar();
			paises = paiDAO.listar();
				
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar litar as pessoas.");
				e.printStackTrace();
			}
		}
	public void novo(){
		pessoa = new Pessoa();
		pessoas = pesDAO.listar();
		paises = paiDAO.listar();
	}
	//MODELOS DE COMUNICA;AO COM A VISAO
	public void salvar() {
	
	try {
		PessoaDAO pesDAO = new PessoaDAO();
		pesDAO.merge(pessoa);
		novo();// limpa a tela  + precisa redezenhar na tela
		//Usando OMNIFACE
		Messages.addGlobalInfo("Salvo com sucesso!");
		
	}catch(RuntimeException e) {
		Messages.addGlobalInfo("Erro ao tentar salvar a pesso.");
			e.printStackTrace();
		}
	}
	//o actionEvent pega da tela
			public void excluir(ActionEvent evento) {
			try {
				pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSeleccionada");
				
				pesDAO.excluir(pessoa);
				//autualiza a tela
				
				pessoas = pesDAO.listar();
				
				Messages.addGlobalInfo(" Pessoa excluida com sucesso!");
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar excluir a pessoa.");
				e.printStackTrace();
				}
			}
			public void editar(ActionEvent evento) {
				
				try {
					pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSeleccionada");
					//cidades = cidDAO.listar();
					//provincias = proDAO.listar();
					}catch(RuntimeException e) {
						Messages.addGlobalInfo("Erro ao tentar editar a pessoa.");
						e.printStackTrace();
					}
			}

}
