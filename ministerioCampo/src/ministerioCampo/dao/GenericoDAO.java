package ministerioCampo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.lang.reflect.ParameterizedType;
import ministerioCampo.util.HibernateConexao;

public class GenericoDAO<Entidade> {


	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericoDAO() {		//USADO PARA FAZER O LISTAR
		this.classe = (Class<Entidade>)((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	//Exemplo de salvar generico
	public void salvar(Entidade ent) {
					
		Session sessao = HibernateConexao.getFabricaSessoes().openSession();		
		Transaction transacao = null;
		
		 try {
	            transacao = sessao.beginTransaction();
	            sessao.save(ent);
	            transacao.commit();
	        } catch (RuntimeException e) {
	            if(transacao != null) {
	            	transacao.rollback();
	            }throw e;
	        } finally {
	            sessao.close();
	        }
	} 
		
	//@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Entidade> listar(){
		
		Session sessao = HibernateConexao.getFabricaSessoes().openSession();
		
		 try{
			 CriteriaBuilder builder = sessao.getCriteriaBuilder();

			 CriteriaQuery<Entidade> criteria = builder.createQuery(classe );
			 Root<Entidade> root = criteria.from(classe);
			 criteria.select( root );
			 criteria.where( builder.equal( root.type(),classe));

			 List<Entidade> resultado = sessao.createQuery( criteria ).getResultList();
			 //Criteria consulta = sessao.createCriteria(classe);
			 //List<Entidade> resultado = consulta.list();
			 return resultado;
		 	}catch(RuntimeException e){
		 		throw e;		 		     
	    }finally {
	    	sessao.close();
	    }
	    
	}
	//listar ordenado
	
	@SuppressWarnings("unchecked")
	public List<Entidade>listar(String campoOrdenado){
		Session sessao = HibernateConexao.getFabricaSessoes().openSession();
		
		try {
			@SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(classe);
			consulta.addOrder(Order.asc(campoOrdenado));
			List<Entidade> resultado = consulta.list();
			return resultado;
			
		}catch(RuntimeException e) {
			throw e;
			
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Entidade buscarPorId(Long codigo){
		
		Session sessao = HibernateConexao.getFabricaSessoes().openSession();
		
		try {
		
			Criteria consulta = sessao.createCriteria(classe);
			//Restricao
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		}catch(RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}
	 
	public void excluir(Entidade ent) {
		Session sessao = HibernateConexao.getFabricaSessoes().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(ent);
			transacao.commit();
			
		}catch(RuntimeException e) {
			if(transacao != null) {
				transacao.rollback();
			}
			throw e;
		}finally {
			sessao.close();
		}
	}
		 
	public void editar(Entidade ent) {
		Session sessao = HibernateConexao.getFabricaSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
            sessao.update(ent);
            transacao.commit();
        } catch (RuntimeException e) {
             if(transacao != null) {
            	 transacao.rollback();
             }throw e;
        } finally {
            sessao.close();
        }
	}
	//Exemplo de merge generico
	public void merge(Entidade ent) {
			Session sessao = HibernateConexao.getFabricaSessoes().openSession();
			Transaction transacao = null;
						
			try {	
				transacao = sessao.beginTransaction();
				     sessao.merge(ent);
		            transacao.commit();
		        } catch (RuntimeException e) {
		            if(transacao != null) {
		               transacao.rollback();
		            }throw e;
		        } finally {
		            sessao.close();
		     }
	}
	

}
