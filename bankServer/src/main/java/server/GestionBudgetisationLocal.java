package server;

import java.util.List;

import javax.ejb.Local;

import Domaine.Budgetisation;

@Local
public interface GestionBudgetisationLocal {
	Boolean addBudgetisation(Budgetisation budgestisation);
	Boolean updateBudgetisation(Budgetisation budgestisation);
	Boolean deleteBudgetisation(Budgetisation budgestisation);
	Budgetisation findBudgetisation(Integer idBudgetisation);
	List<Budgetisation>findAllBudgetisation();
}
