package ministerioCampo.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ministerioCampo.dao.CidadeDAO;
import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dao.PessoaDAO;
import ministerioCampo.dominio.Cidade;
import ministerioCampo.dominio.Pais;
import ministerioCampo.dominio.Pessoa;

public class PessoaDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		CidadeDAO cidDAO = new CidadeDAO();
		Cidade cid = cidDAO.buscarPorId(8L);
		
		Pessoa pes = new Pessoa();
		
		pes.setNome("Edinho");
		pes.setBi("133390060LAD19087");
		pes.setCelular("925897654");
		pes.setComplemento("5");
		pes.setEmail("edinho@hotmail.com");
		pes.setNumero(new Short ((short) 12));
		pes.setRua("Rua C");
		pes.setTelefone("22222222098");
		pes.setCidade(cid);
		
		
		PessoaDAO pesDAO = new PessoaDAO();
		pesDAO.merge(pes);
		
		System.out.println("Pessoa salva com sucesso.");
	}
	
	@Test
	@Ignore
	public void listar() {
		//Provincia provincia = new Provincia();
		PessoaDAO pesDAO = new PessoaDAO();
		List<Pessoa>resultado = pesDAO.listar();
		
		for(Pessoa pes : resultado) {			
			System.out.println("Codigo da Pessoa " +pes.getCod() + "\nNome " + pes.getNome() + "\nBi " + pes.getBi() +
					"\nCelular " +pes.getCelular() +  "\nTelefone" + pes.getTelefone() +"\nEmail" + pes.getEmail() + "\nCmplemento" +
					pes.getComplemento()+ "\nRua"+pes.getRua()+ "\nNumero"+ pes.getNumero()+"\nCodigo Pais"+ pes.getCidade().getCod() +"\nNome Cidade" + pes.getCidade().getNomeCidade());
		}
		System.out.println("Total de registos:" + resultado.size());
	}
	@Test
	@Ignore
	public void buscarPorId() {
		Long codigo = 18L;
		
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscarPorId(codigo);
		
		if(pes == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			
		System.out.println(" Registro encontrado.");
		System.out.println("Codigo da Pessoa " +pes.getCod() + "\nNome " + pes.getNome() + "\nBi " + pes.getBi() +
				"\nCelular " +pes.getCelular() +  "\nTelefone" + pes.getTelefone() +"\nEmail" + pes.getEmail() + "\nCmplemento" +
				pes.getComplemento()+ "\nRua"+pes.getRua()+ "\nNumero"+ pes.getNumero()+"\nCodigo Cidade"+ pes.getCidade().getCod() +"\nNome Cidade" + pes.getCidade().getNomeCidade());
		}
	}
	
	//carece de alteracao
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 18L;
		

		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscarPorId(codigo);
				
		if(pes == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			pesDAO.excluir(pes);
			System.out.println(" Registro removido.");
			System.out.println("Codigo da Pessoa " +pes.getCod() + "\nNome " + pes.getNome() + "\nBi " + pes.getBi() +
					"\nCelular " +pes.getCelular() +  "\nTelefone" + pes.getTelefone() +"\nEmail" + pes.getEmail() + "\nCmplemento" +
					pes.getComplemento()+ "\nRua"+pes.getRua()+ "\nNumero"+ pes.getNumero()+"\nCodigo Cidade"+ pes.getCidade().getCod() +"\nNome Cidade" + pes.getCidade().getNomeCidade());
		}
		
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 21L;
		Long codigoPai = 17L;
		
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscarPorId(codigo);
		
		System.out.println(" Registro da Pessoa a ser editado.");
		System.out.println("\nNome " + pes.getNome() + "\nBi " + pes.getBi() +
				"\nCelular " +pes.getCelular() +  "\nTelefone" + pes.getTelefone() +"\nEmail" + pes.getEmail() + "\nCmplemento" +
				pes.getComplemento()+ "\nRua"+pes.getRua()+ "\nNumero"+ pes.getNumero()+"\n");
					
		PaisDAO paiDAO = new PaisDAO();
		Pais pai = paiDAO.buscarPorId(codigoPai);
		
		System.out.println(" Registro do Pais a ser editado.");
		System.out.println("\nCodigo Cidade"+ pes.getCidade().getCod() +"\nNome Cidade" + pes.getCidade().getNomeCidade());
		
		pai.setNomePais("Angola");		
		paiDAO.editar(pai);
		
		System.out.println(" Registro editado.");
		System.out.println("Codigo do Pais " +pes.getCod() + "\nTelefone" + pes.getTelefone()+" \n");
	}

}
