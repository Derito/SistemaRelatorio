package ministerioCampo.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ministerioCampo.dao.CidadeDAO;
import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dao.ProvinciaDAO;
import ministerioCampo.dominio.Cidade;
import ministerioCampo.dominio.Pais;
import ministerioCampo.dominio.Provincia;

public class CidadeDAOTest {

	@Test
	//@Ignore
	public void salvar() {
		
	
		ProvinciaDAO proDAO = new ProvinciaDAO();
		Provincia pro = proDAO.buscarPorId(4L);
			
		Cidade cid = new Cidade();
		cid.setNomeCidade("Viana");
		cid.setSigla("VIA");
		cid.setProvincia(pro);
					  
		CidadeDAO cidDAO = new CidadeDAO();
		cidDAO.merge(cid);
		
	}
	@Test
	@Ignore
	public void listar() {
		//Provincia provincia = new Provincia();
		CidadeDAO cidDAO = new CidadeDAO();
		List<Cidade>resultado = cidDAO.listar();
		
		for(Cidade cid : resultado) {			
			System.out.println("Codigo da Cidade " +cid.getCod() + "\nNome da Cidade " + cid.getNomeCidade() + "\nSigla da Cidade " + cid.getSigla()+
					"\nCodigo da pais " +" \n ");
		}
		System.out.println("Total de registos:" + resultado.size());
	}
	@Test
	@Ignore
	public void buscarPorId() {
		Long codigoCid = 8L;
		
		CidadeDAO cidDAO = new CidadeDAO();
		Cidade cid = cidDAO.buscarPorId(codigoCid);
		
		if(cid == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			
		System.out.println(" Registro encontrado.");
		System.out.println("Codigo da Cidade " +cid.getCod() + "\nNome da Cidade " + cid.getNomeCidade() + "\nSigla da Cidade " + cid.getSigla()+
				"\nCodigo da pais " +" \n ");
		}
	}
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 12L;
		
		CidadeDAO cidDAO = new CidadeDAO();
		Cidade cid = cidDAO.buscarPorId(codigo);
				
		if(cid == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			cidDAO.excluir(cid);
			System.out.println(" Registro removido.");
			System.out.println("Codigo da Cidade " +cid.getCod() + "\nNome da Cidade " + cid.getNomeCidade() + "\nSigla da Cidade " + cid.getSigla()+
					"\nCodigo da pais " +" \n ");
			}
	}
	@Test
	@Ignore
	public void editar() {
		Long codigoCid = 11L;
		Long codigoPro = 4L;
		
		PaisDAO paiDAO = new PaisDAO();
		Pais pro = paiDAO.buscarPorId(codigoPro);
		
		System.out.println(" Registro Provincia a ser editado.");
		System.out.println("Codigo da provincia " + pro.getCod()+
				"\nNome do pais " + pro.getNomePais()+ "\nSigla do pais " + pro.getSigla());
				
		CidadeDAO cidDAO = new CidadeDAO();
		Cidade cid = cidDAO.buscarPorId(codigoCid);
		
		System.out.println(" Registro a ser editado.");
		System.out.println("Codigo da Cidade " +cid.getCod() + "\nNome da Cidade " + cid.getNomeCidade() + "\nSigla da Cidade " + cid.getSigla()+
				"\nCodigo da pais " +" \n ");
		
		cid.setNomeCidade("Lisboa");
		cidDAO.editar(cid);
		
		System.out.println(" Registro editado.");
		System.out.println("Codigo da Cidade " +cid.getCod() + "\nNome da Cidade " + cid.getNomeCidade() + "\nSigla da Cidade " + cid.getSigla()+
				"\nCodigo da pais " +" \n ");
	}
}

