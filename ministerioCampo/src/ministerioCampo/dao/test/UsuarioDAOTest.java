package ministerioCampo.dao.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import ministerioCampo.dao.PessoaDAO;
import ministerioCampo.dao.UsuarioDAO;
import ministerioCampo.dominio.Pessoa;
import ministerioCampo.dominio.Usuario;


public class UsuarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscarPorId(14L);
		
		System.out.println("Pessoa encontrada.");
		System.out.println("Nome:" + pes.getNome());
		
		Usuario uso = new Usuario();
		
		uso.setPessoa(pes);
		uso.setSenhaSemCriptografia("123");
		
		SimpleHash hash = new SimpleHash("md5", uso.getSenhaSemCriptografia());
		uso.setSenha(hash.toHex());
		uso.setActivo(true);
		uso.setTipo('P');
		
		UsuarioDAO usoDAO = new UsuarioDAO();
		usoDAO.merge(uso);
		
		System.out.println("Usuario salvo com sucesso.");
	}
	@Test
	@Ignore
	public void autenticar() {
		
		String email = "helder@hotmail.com";
		String senha = "123";
		
		UsuarioDAO usoDAO = new UsuarioDAO();
		Usuario uso = usoDAO.autenticar(email, senha);
		
		System.out.println("Usuário autenticado com sucesso!" + uso );//.getPessoa().getEmail()+"\nSenha criptografada "+ uso.getSenha());
		
		
	}
}
