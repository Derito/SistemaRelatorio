package ministerioCampo.dao.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ministerioCampo.dao.PaisDAO;
import ministerioCampo.dao.ProvinciaDAO;
import ministerioCampo.dominio.Pais;
import ministerioCampo.dominio.Provincia;

public class ProvinciaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
	PaisDAO paiDAO = new PaisDAO();
	Pais pai = paiDAO.buscarPorId(2L);		
		
		Provincia pro = new Provincia();
		
		pro.setNomeProvincia("Rio de Janeiro");	
		pro.setSiglaProvincia("RJ");
		pro.setPais(pai);
					    
		ProvinciaDAO proDAO = new ProvinciaDAO();
		proDAO.merge(pro);
		
	}
	@Test
	@Ignore
	public void listar() {
		//Provincia provincia = new Provincia();
		ProvinciaDAO proDAO = new ProvinciaDAO();
		List<Provincia>resultado = proDAO.listar();
		
		for(Provincia pro : resultado) {			
			System.out.println("Codigo da Provincia " + pro.getCod()+
					"\nNome da Provincia " + pro.getNomeProvincia()+ "\nSigla" + pro.getSiglaProvincia()+" \nCodigo Pais"+ pro.getPais().getCod()+
					"\nNome da Pais " + pro.getPais().getNomePais()+"\n");
		}
		System.out.println("Total de registos:" + resultado.size());
	}
	@Test
	@Ignore
	public void buscarPorId() {
		Long codigoPro = 14L;
		
		ProvinciaDAO proDAO = new ProvinciaDAO();
		Provincia pro = proDAO.buscarPorId(codigoPro);
		
		if(pro == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			
		System.out.println(" Registro encontrado.");
		System.out.println("Codigo do Provincia "  + pro.getCod()+
				"\nNome da provincia " + pro.getNomeProvincia()+ "\nSigla" + pro.getSiglaProvincia()+" \nCodigo Pais" + pro.getPais().getCod());
		}
	}
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 14L;
		

		ProvinciaDAO proDAO = new ProvinciaDAO();
		Provincia pro = proDAO.buscarPorId(codigo);;
				
		if(pro == null) {
			System.out.println("Não foi encontrado nenhum registro.");
		}else {
			proDAO.excluir(pro);
			System.out.println(" Registro removido.");
			System.out.println("Codigo do Provincia "  + pro.getCod()+
					"\nNome da provincia " + pro.getNomeProvincia()+ "\nSigla" + pro.getSiglaProvincia()+" \nCodigo Pais" + pro.getPais().getCod());
			}
		
	}
	@Test
	@Ignore
	public void editar() {
		Long codigoPai = 11L;
		Long codigoPro = 4L;
		
		ProvinciaDAO proDAO = new ProvinciaDAO();
		Provincia pro = proDAO.buscarPorId(codigoPro);
		
		System.out.println(" Registro da Provincia a ser editado.");
		System.out.println("Codigo da Provincia " + pro.getCod()+
				 "\nNome da Provincia " + pro.getNomeProvincia());
				
		PaisDAO paiDAO = new PaisDAO();
		Pais pai = paiDAO.buscarPorId(codigoPai);
		
		System.out.println(" Registro do Pais a ser editado.");
		System.out.println("Codigo do Pais " +pai.getCod() + "\nNome do Pais " + pai.getNomePais() + "\n");
		
		pai.setNomePais("Portugal");
		pro.setPais(pai);
		proDAO.editar(pro);
		
		System.out.println(" Registro editado.");
		System.out.println("Codigo da Provincia "  + pro.getCod()+
				"\nNome da Provincia " + pro.getNomeProvincia()+ "\nNome do Pais" + pro.getPais().getNomePais()+" \n");
	}
}

