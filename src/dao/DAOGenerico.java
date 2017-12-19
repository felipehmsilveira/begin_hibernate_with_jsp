package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;


public abstract class DAOGenerico<Entity> {

	
	private EntityManagerFactory entityManagerFactory;
	private Class<Entity> persistentClass;

	@SuppressWarnings("unchecked")	
	public DAOGenerico(EntityManagerFactory emf){
		this.setEntityManagerFactory(emf);
		this.entityManagerFactory = emf;
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();  
	    persistentClass = (Class<Entity>) parameterizedType.getActualTypeArguments()[0];  
	}
	
	/**
	 * Executa o merge do objeto que se encontra em mem�ria.
	 * 
	 * @param objeto
	 *            a ser realizado o merge
	 * @return objeto que foi executado o merge
	 */
	public Entity update(Entity objeto) {
		
		EntityManager em = this.entityManagerFactory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		objeto = em.merge(objeto);
		
		tx.commit();
		
		em.close();
		
		return objeto;
	}
	
	public final List<Entity> getAll() {
		List<Entity> instance = null;
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			instance = ((List<Entity>) em.createQuery(
					"from " + getPersistentClass().getName()).getResultList());
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		em.close();
		return instance;
	}
	
	

	/**
	 * Salva o objeto atual na base de dados.
	 * 
	 * @param objeto a ser salvo
	 */
	public void insert(Entity objeto) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();		
		try {
			tx.begin();
			em.persist(objeto);
			tx.commit();
			em.close();
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			tx.rollback();
		}
	}

	/**
	 * Salva o objeto atual na base de dados.
	 * 
	 * @param objeto
	 *            a ser salvo
	 */
	public final void insertCollection(Collection<Entity> colecao) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			for (Entity entidade : colecao) {
				em.persist(entidade);	
			}
			
			tx.commit();
			
			em.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove o objeto da base de dados.
	 * 
	 * @param objeto
	 *            a ser removido
	 */
	public final void remove(Entity objeto) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Este merge foi incluido para permitir a exclusao de objetos no estado Detached
		objeto = em.merge(objeto);
		
		em.remove(objeto);
		
		tx.commit();
		
		em.close();
	}

	
	
	/**
	 * Busca o objeto uma vez passado sua chave como par�metro.
	 * 
	 * @param chave
	 *            identificador
	 * @return Objeto do tipo T
	 */
	public final Entity searchByKey(Serializable chave) {
		Entity instance = null;
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			instance = (Entity) em.find(getPersistentClass(), chave);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		em.close();
		return instance;
	}

	/**
	 * Atualiza o objeto que se encontra em mem�ria.
	 * 
	 * @param object
	 *            objeto a ser atualizado
	 */
	public final void refresh(Entity object) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		em.refresh(object);
		em.close();
	}
	
	/**
	 * Utilizado para se injetar o Entity manager no DAO.
	 * 
	 * @param entityManager
	 *            entity manager
	 */
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManagerFactory getEntityManagerFactory() {		
		return entityManagerFactory;
	}

	
	/**
	 * Busca a classe persistente do objeto utilizado na classe.
	 * 
	 * @return classe persistente
	 */
	protected final Class<Entity> getPersistentClass() {
		return persistentClass;
	}
	
}

