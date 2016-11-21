package server;

import java.util.List;

import javax.ejb.Remote;

import Domaine.Budgetisation;


@Remote
public interface GestionBudgetisationRemote {
	Boolean addBudgetisation(Budgetisation budgestisation);
	Boolean updateBudgetisation(Budgetisation budgestisation);
	Boolean deleteBudgetisation(Budgetisation budgestisation);
	Budgetisation findBudgetisation(Integer idBudgetisation);
	List<Budgetisation>findAllBudgetisation();
}
