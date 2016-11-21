package server;

import java.util.List;

import javax.ejb.Local;


import Domaine.TauxDeChange;

@Local
public interface GestionTauxDeChangeLocal {
	Boolean addTauxDeChange(TauxDeChange tauxDeChange);
	Boolean updateTauxDeChange(TauxDeChange tauxDeChange);
	Boolean deleteTauxDeChange(TauxDeChange tauxDeChange);
	TauxDeChange findTauxDeChange(Integer idTauxDeChange);
	List<TauxDeChange>findAllTauxDeChange();
}
