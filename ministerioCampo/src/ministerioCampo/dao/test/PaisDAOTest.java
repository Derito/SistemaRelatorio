package ministerioCampo.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dominio.Pais;


public class PaisDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		Pais pais = new Pais();
		pais.setNomePais("Portugal");
		pais.setSigla("POR");
		
		PaisDAO proDAO = new PaisDAO();
		proDAO.merge(pais);				
	}
	@Test
	//@Ignore
	public void listar() {
		//Pais pais = new Pais();
		PaisDAO proDAO = new PaisDAO();
		List<Pais>resultado = proDAO.listar();
		
		for(Pais pais : resultado) {			
			System.out.println( pais.getNomePais() + " - " + pais.getSigla());
		}
		System.out.println("Total de registos:" + resultado.size());
	}
	@Test
	@Ignore
	public void buscarPorId() {
		Long codigo = 2L;
		
		PaisDAO proDAO = new PaisDAO();
		Pais pais = proDAO.buscarPorId(codigo);
		
		if(pais == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			
		System.out.println(" Registro encontrado.");
		System.out.println( pais.getCod() + " - "+ pais.getNomePais() + " - " + pais.getSigla());
		}
	}
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		
		PaisDAO proDAO = new PaisDAO();
		Pais pais = proDAO.buscarPorId(codigo);
				
		if(pais == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			proDAO.excluir(pais);
			System.out.println(" Registro removido.");
			System.out.println( pais.getCod() + " - "+ pais.getNomePais() + " - " + pais.getSigla());
		}
	}
	@Test
	@Ignore
	public void editar() {
		Long codigo = 5L;
		
		PaisDAO proDAO = new PaisDAO();
		Pais pais = proDAO.buscarPorId(codigo);
		pais.setNomePais("França");
		pais.setSigla("FRA");
			proDAO.editar(pais);
			System.out.println(" Registro actualizado.");
			System.out.println( pais.getCod() + " - "+ pais.getNomePais() + " - " + pais.getSigla());
		}
	@Test
	@Ignore
	public void merge() {
		
		Pais pais = new Pais();
		pais.setNomePais("Malange");
		pais.setSigla("MEG");
		
		PaisDAO proDAO = new PaisDAO();
		proDAO.merge(pais);				
	}
}
