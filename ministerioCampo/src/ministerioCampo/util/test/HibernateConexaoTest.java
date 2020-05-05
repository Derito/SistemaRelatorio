package ministerioCampo.util.test;

import org.hibernate.Session;
import org.junit.Test;
import ministerioCampo.util.HibernateConexao;

public class HibernateConexaoTest {

	@Test
	public void conectar() {
		
		Session sessao =  HibernateConexao.getFabricaSessoes().openSession();		
		sessao.close();	
		HibernateConexao.getFabricaSessoes().close();
	}
}
