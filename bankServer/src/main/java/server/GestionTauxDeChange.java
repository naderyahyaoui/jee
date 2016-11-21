package server;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import Domaine.TauxDeChange;

/**
 * Session Bean implementation class GestionTauxDeChange
 */
@Stateless
@LocalBean
public class GestionTauxDeChange implements GestionTauxDeChangeRemote, GestionTauxDeChangeLocal {
	@PersistenceContext(unitName="bankServer")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionTauxDeChange() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addTauxDeChange(TauxDeChange tauxDeChange) {
		try{
			entityManager.persist(tauxDeChange);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public Boolean updateTauxDeChange(TauxDeChange tauxDeChange) {
		try{
			entityManager.merge(tauxDeChange);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public Boolean deleteTauxDeChange(TauxDeChange tauxDeChange) {
		try{
			entityManager.remove(entityManager.merge(tauxDeChange));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public TauxDeChange findTauxDeChange(Integer idTauxDeChange){
		TauxDeChange tauxDeChange= null;
		try{
			tauxDeChange=entityManager.find(TauxDeChange.class, idTauxDeChange);
			
		}
		catch(Exception e){
			
		}
		return tauxDeChange;
		
	}

	@Override
	public List<TauxDeChange> findAllTauxDeChange() {
		Query query=entityManager.createQuery("select T from TauxDeChange");
		   return query.getResultList();
	}

	

	

}
