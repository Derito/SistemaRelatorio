package ministerioCampo.dao.test;

import java.text.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import ministerioCampo.dao.AnciaoDAO;
import ministerioCampo.dao.CongregacaoDAO;
import ministerioCampo.dao.PessoaDAO;
import ministerioCampo.dao.PublicadorDAO;
import ministerioCampo.dominio.Anciao;
import ministerioCampo.dominio.Congregacao;
import ministerioCampo.dominio.Pessoa;
import ministerioCampo.dominio.Publicador;


public class AnciaoDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pessoa = pesDAO.buscarPorId(12L);
		
		PublicadorDAO pubDAO = new PublicadorDAO();
	    Publicador pub = pubDAO.buscarPorId(23L);		
		
		CongregacaoDAO congDAO = new CongregacaoDAO();
		Congregacao congregacao = congDAO.buscarPorId(19L);
		
		Anciao anc = new Anciao();
		
		anc.setResponsabilidade("Secretário");
		anc.setCongregacao(congregacao);
		anc.setPublicador(pub);
		anc.setPessoa(pessoa);
				
		AnciaoDAO ancDAO = new AnciaoDAO();
		ancDAO.merge(anc);
		
		System.out.println("Anciao salvo com sucesso.");
		
	}

}
