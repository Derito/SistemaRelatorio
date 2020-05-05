package ministerioCampo.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import ministerioCampo.dao.UsuarioDAO;
import ministerioCampo.dominio.Pessoa;
import ministerioCampo.dominio.Usuario;


@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	
	
	private  Usuario uso;
	private Usuario usoLogado;

	public Usuario getUso() {
		return uso;
	}

	public void setUso(Usuario uso) {
		this.uso = uso;
	}
	
	
	public Usuario getUsoLogado() {
		return usoLogado;
	}

	public void setUsoLogado(Usuario usoLogado) {
		this.usoLogado = usoLogado;
	}

	@PostConstruct//INSTANCIA O USUARIO e o Publicador PARA SER CHAMADO NA TELA
	public void iniciar() {
		 uso = new Usuario();
		//Instancia vazia de pessoa
		uso.setPessoa(new Pessoa());
	}
	public void login() {
	try {
		UsuarioDAO usoDAO = new UsuarioDAO();
		usoLogado = usoDAO.autenticar(uso.getPessoa().getEmail(), uso.getSenha());
		if(usoLogado == null) {
			Messages.addGlobalError("Usuario ou senha incorrectos");
			return;
		}
		//Redireccionando para a tela principal SEM BUSCA NO BANCO		
			Faces.redirect("./pages/principal.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
			Messages.addGlobalError(e.getMessage());
		}
	}
	public boolean temPermissao(List<String> permissoes) {
		for(String permissao: permissoes) {
			if(usoLogado.getTipo() == permissao.charAt(0)) {
				return true;
			}
		}
		return false;
	}
}
