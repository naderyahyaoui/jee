package Delegate;

import java.util.List;

import Domaine.TauxDeChange;
import locator.ServiceLocator;
import server.GestionTauxDeChangeRemote;

public class TauxDeChangeDelegate {
  private static GestionTauxDeChangeRemote gestionTauxDeChangeRemote;
  private static GestionTauxDeChangeRemote getRemote(){
	 gestionTauxDeChangeRemote=(GestionTauxDeChangeRemote) ServiceLocator.getInstance().getProxy("/bankServer/GestionTauxDeChange!server.GestionTauxDeChangeRemote");
	  return gestionTauxDeChangeRemote;
  }
  public static boolean addTauxDeChangeDelegate(TauxDeChange i){
	  return getRemote().addTauxDeChange(i);
  }
  public static boolean deleteTauxDeChange(TauxDeChange i){
	  return getRemote().deleteTauxDeChange(i);
  }
  public static boolean updateTauxDeChange(TauxDeChange i){
	  return getRemote().deleteTauxDeChange(i);
	  
  }
  public static TauxDeChange findTauxDeChangeDelegate(Integer idTauxDeChange){
	  return getRemote().findTauxDeChange(idTauxDeChange);
  }
  public static List<TauxDeChange> findAllTauxDeChangeDelegate(){
	  return (List<TauxDeChange>) getRemote().findAllTauxDeChange();
  }
}
