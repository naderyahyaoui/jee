package server;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Domaine.Budgetisation;
import Domaine.TauxDeChange;

/**
 * Session Bean implementation class GestionBudgetisation
 */
@Stateless
@LocalBean
public class GestionBudgetisation implements GestionBudgetisationRemote, GestionBudgetisationLocal {
	@PersistenceContext(unitName="bankServer")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionBudgetisation() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addBudgetisation(Budgetisation budgestisation) {
		try{
			entityManager.persist(budgestisation);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public Boolean updateBudgetisation(Budgetisation budgestisation) {
		try{
			entityManager.merge(budgestisation);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public Boolean deleteBudgetisation(Budgetisation budgestisation) {
		try{
			entityManager.remove(entityManager.merge(budgestisation));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public Budgetisation findBudgetisation(Integer idBudgetisation) {
		Budgetisation budgetisation= null;
		try{
			budgetisation=entityManager.find(Budgetisation.class, idBudgetisation);
			
		}
		catch(Exception e){
			
		}
		return budgetisation;
	}

	@Override
	public List<Budgetisation> findAllBudgetisation() {
		Query query=entityManager.createQuery("select B from Budgetisation");
		   return query.getResultList();
	}

}
