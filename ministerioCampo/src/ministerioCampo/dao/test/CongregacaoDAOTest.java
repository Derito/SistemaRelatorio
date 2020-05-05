package ministerioCampo.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ministerioCampo.dao.CongregacaoDAO;
import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dominio.Congregacao;
import ministerioCampo.dominio.Pais;

public class CongregacaoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
	PaisDAO paiDAO = new PaisDAO();
	Pais pai = paiDAO.buscarPorId(1L);
			
		Congregacao con = new Congregacao();
		con.setNome("Nova Vila Estoril 14");
		con.setPais(pai);
					    
		CongregacaoDAO conDAO = new CongregacaoDAO();
		conDAO.merge(con);
		
		System.out.println("Congregação salva com sucesso!");
		
	}
	@Test
	@Ignore
	public void listar() {
		
		CongregacaoDAO conDAO = new CongregacaoDAO();
		//PaisDAO paiDAO = new PaisDAO();
		List<Congregacao>resultado = conDAO.listar();
		
		for(Congregacao con : resultado) {			
			System.out.println("Codigo da  Congregacaos " +con.getCod() + "\nNome da Congregação " + con.getNome() + 
					"\nCodigo do pais " + con.getPais().getCod()+ "\nNome do pais " + con.getPais().getNomePais()+ "\nSigla da pais" + con.getPais().getSigla()+" \n");
		}
		System.out.println("Total de registos:" + resultado.size());
	}
	@Test
	@Ignore
	public void buscarPorId() {
		Long codigoCon = 8L;
		
		CongregacaoDAO conDAO = new CongregacaoDAO();
		Congregacao con = conDAO.buscarPorId(codigoCon);
		
		if(con == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			
		System.out.println(" Registro encontrado.");
		System.out.println("Codigo da Congregação " +con.getCod() + "\nNome da Congregação " + con.getNome() + 
				"\nCodigo do pais " + con.getPais().getCod()+ "\nNome do pais " + con.getPais().getNomePais()+ "\nSigla da pais " + con.getPais().getSigla()+
				"\n");
		}
	}
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 12L;
		
		CongregacaoDAO conDAO = new CongregacaoDAO();
		Congregacao con = conDAO.buscarPorId(codigo);
				
		if(con == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			conDAO.excluir(con);
			System.out.println(" Registro removido.");
			System.out.println("Codigo da Congregação " +con.getCod() + "\nNome da Congregação " + con.getNome() + 
					"\nCodigo do pais " + con.getPais().getCod()+ "\nNome do pais " + con.getPais().getNomePais()+ "\nSigla da pais " + con.getPais().getSigla()+
					"\n");
			}
	}
	@Test
	@Ignore
	public void editar() {
		Long codigoCon = 11L;
		Long codigoPai = 4L;
		
		PaisDAO paiDAO = new PaisDAO();
		Pais pais = paiDAO.buscarPorId(codigoPai);
		
		System.out.println(" Registro Pais a ser editado.");
		System.out.println("Codigo da pais " + pais.getCod()+
				"\nNome do pais " + pais.getNomePais()+ "\nSigla do pais " + pais.getSigla());
				
		CongregacaoDAO conDAO = new CongregacaoDAO();
		Congregacao con = conDAO.buscarPorId(codigoCon);
		
		System.out.println(" Registro a ser editado.");
		System.out.println("Codigo da Congregação " +con.getCod() + "\nNome da Congregação " + con.getNome() + "\nCodigo do pais " + con.getPais().getCod()+
				"\nNome do pais " + con.getPais().getNomePais()+ "\nSigla da pais " + con.getPais().getSigla());
		
		con.setNome("Nova Vila Estoril 12");
		con.setPais(pais);
		conDAO.editar(con);
		
		System.out.println(" Registro editado.");
		System.out.println("Codigo da Congregação " +con.getCod() + "\nNome da Congregação " + con.getNome() + "\nCodigo do pais " + con.getPais().getCod()+
				"\nNome do pais " + con.getPais().getNomePais()+ "\nSigla da pais " + con.getPais().getSigla());
		
	}
}

