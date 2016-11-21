package server;

import java.util.List;

import javax.ejb.Remote;


import Domaine.TauxDeChange;

@Remote
public interface GestionTauxDeChangeRemote {
	Boolean addTauxDeChange(TauxDeChange tauxDeChange);
	Boolean updateTauxDeChange(TauxDeChange tauxDeChange);
	Boolean deleteTauxDeChange(TauxDeChange tauxDeChange);
	TauxDeChange findTauxDeChange(Integer idTauxDeChange);
	List<TauxDeChange>findAllTauxDeChange();
}
