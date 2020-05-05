package ministerioCampo.bean;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.omnifaces.util.Messages;

import ministerioCampo.dao.PessoaDAO;
import ministerioCampo.dao.UsuarioDAO;
import ministerioCampo.dominio.Pessoa;
import ministerioCampo.dominio.Usuario;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class UsuarioBean implements Serializable{
	
	UsuarioDAO usuDAO = new UsuarioDAO();

	PessoaDAO pesDAO = new PessoaDAO();
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Pessoa> pessoas;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
		// Metodo listar
		public void listar() {
			try {
				usuarios= usuDAO.listar();
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar listar os Usuários.");
				e.printStackTrace();
			}
		}
		public void novo() {
			try {
			usuarios = usuDAO.listar();
			}catch(RuntimeException e) {
				Messages.addGlobalInfo("Erro ao tentar  inserir um novo Usuário.");
				e.printStackTrace();
			}
		}
		public void salvar() {
			try {
				
				usuDAO.merge(usuario);
				novo();// limpa a tela  + precisa redezenhar na tela
				//autualiza a tela
				usuarios = usuDAO.listar();
				pessoas = pesDAO.listar();
				//Usando OMNIFACE
				Messages.addGlobalInfo("Salvo com sucesso!");
				
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar salvar o Usuário.");
					e.printStackTrace();
				}
		}
		//o actionEvent pega da tela
			public void excluir(ActionEvent evento) {
			try {
				usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSeleccionado");
				
				usuDAO.excluir(usuario);
				//autualiza a tela
				pessoas = pesDAO.listar();
				usuarios = usuDAO.listar();
				
				Messages.addGlobalInfo(" Usuário excluido com sucesso!");
			}catch(RuntimeException e) {
				Messages.addGlobalError("Erro ao tentar excluir o Usuário.");
				e.printStackTrace();
				}
		}
			public void editar(ActionEvent evento) {
				
				try {
					usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSeleccionado");
					//cidades = cidDAO.listar();
					//provincias = proDAO.listar();
					}catch(RuntimeException e) {
						Messages.addGlobalInfo("Erro ao tentar editar o usuario.");
						e.printStackTrace();
					}
			}

}
