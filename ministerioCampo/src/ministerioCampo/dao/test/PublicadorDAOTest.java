package ministerioCampo.dao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;

import ministerioCampo.dao.CongregacaoDAO;
import ministerioCampo.dao.PessoaDAO;
import ministerioCampo.dao.PublicadorDAO;
import ministerioCampo.dominio.Congregacao;
import ministerioCampo.dominio.Pessoa;
import ministerioCampo.dominio.Publicador;


public class PublicadorDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pessoa = pesDAO.buscarPorId(14L);
		
		CongregacaoDAO congDAO = new CongregacaoDAO();
		Congregacao congregacao = congDAO.buscarPorId(19L);
		
		Publicador pub = new Publicador();
		
		pub.setPessoa(pessoa);
		pub.setCongregacao(congregacao);
		pub.setBaptizado(true);//campo boolean
		//publicador.setDataBaptismo(new Date());//pegando a hora do sistema
		pub.setIniPublicador(new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2020"));
		pub.setDataBaptismo(new SimpleDateFormat("dd/MM/yyyy").parse("12/03/1920"));//Digitando a data
		
		PublicadorDAO pubDAO = new PublicadorDAO();
		pubDAO.merge(pub);
		
		System.out.println("Publicador salvo com sucesso.");
		
	}

}
