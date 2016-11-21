package Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import Domaine.Budgetisation;
import Domaine.TauxDeChange;
import server.GestionBudgetisationRemote;
import server.GestionTauxDeChangeRemote;

public class Test {
static GestionTauxDeChangeRemote remote;
static GestionBudgetisationRemote remotebudgetisation;
public static void doAddBudgetisation(GestionBudgetisationRemote remotebudgetisation){
	Budgetisation budgetisation=new Budgetisation();
	budgetisation.setDepot(12.0);
	budgetisation.setCredit(12.0);
	budgetisation.setTauxInteret(1.0);
	budgetisation.setMois("jjj");
	budgetisation.setDate("ss");
	budgetisation.setMontant(12.0);
	budgetisation.setBudget(12.0);
	budgetisation.setPartenaire("bte");
	if(remotebudgetisation.addBudgetisation(budgetisation)){
		System.out.println("ok");
	}
	else {
		System.out.println("erreur");
	}
}
public static void doAddTauxDeChange(GestionTauxDeChangeRemote remote){
	TauxDeChange tauxDeChange= new TauxDeChange();
	tauxDeChange.setCurrency("US");
	tauxDeChange.setCoutAcheteur(1.36);
	tauxDeChange.setCoutVendeur(45.23);
	if(remote.addTauxDeChange(tauxDeChange)){
		System.out.println("ok");
	}
	else {
		System.out.println("erreur");
	}
}


public static void doUpdateTauxDeChange(GestionTauxDeChangeRemote remote){
	TauxDeChange tauxDeChange= remote.findTauxDeChange(2);
	tauxDeChange.setCurrency("euros");
	if(remote.updateTauxDeChange(tauxDeChange)){
		System.out.println("ok");
	}
	else {
		System.out.println("erreur");
	}
}
public static void doDeleteTauxDeChange(GestionTauxDeChangeRemote remote){
	TauxDeChange tauxDeChange= remote.findTauxDeChange(1);
	
	if(remote.deleteTauxDeChange(tauxDeChange)){
		System.out.println("ok");
	}
	else {
		System.out.println("erreur");
	}
	
	
}
 

	public static void main(String[] args) {
		try{
			Context ctx=new InitialContext();
			//remote=(GestionTauxDeChangeRemote) ctx.lookup("/bankServer/GestionTauxDeChange!server.GestionTauxDeChangeRemote");
			remotebudgetisation=(GestionBudgetisationRemote) ctx.lookup("/bankServer/GestionBudgestisation!server.GestionBudgestisationRemote");
			doAddBudgetisation(remotebudgetisation);
		    //doDeleteBudgetisation(remote1);
		    //doAddTauxDeChange(remote);
			//doUpdateTauxDeChange(remote);
			//doDeleteTauxDeChange(remote);
		}
		catch(NamingException ex){
			ex.printStackTrace();
		}

	}

}
