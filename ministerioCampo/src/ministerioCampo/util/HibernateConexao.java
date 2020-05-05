package ministerioCampo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConexao {
	
	private static final SessionFactory fabricaSessoes = criaFabricaSessoes();

	//@Produces // Informa que o metodo ]e produtor de conexões usando CDI
	private static SessionFactory criaFabricaSessoes() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Erro ao criar a sessão." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getFabricaSessoes() {
		return fabricaSessoes;
	}

	public static void desconecta() {
		// Close caches and connection pools
		getFabricaSessoes().close();
	}

}

