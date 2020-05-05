package ministerioCampo.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.apache.shiro.crypto.hash.SimpleHash;
import ministerioCampo.dominio.Usuario;
import ministerioCampo.util.HibernateConexao;

public class UsuarioDAO extends GenericoDAO<Usuario>{
	
	//Metodo para autenticar 
	
		@SuppressWarnings("deprecation")
		public Usuario autenticar(String email, String senha) {
			
			Session sessao = HibernateConexao.getFabricaSessoes().openSession();
			
			try {
				
				Criteria consulta = sessao.createCriteria(Usuario.class);
				consulta.createAlias("pessoa", "p");
								
				consulta.add(Restrictions.eq("p.email", email));
				
				SimpleHash hash = new SimpleHash("md5", senha);
				
				consulta.add(Restrictions.eq("senha", hash.toHex()));
				
				Usuario resultado = (Usuario) consulta.uniqueResult();
				
				return resultado;
			}catch(RuntimeException e) {
				throw e;
				
			}finally {
				sessao.close();
			}
		}



}
