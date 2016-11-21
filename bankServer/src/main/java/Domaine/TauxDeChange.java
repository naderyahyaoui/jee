package Domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TauxDeChange implements Serializable {
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int idTaux;
String currency;
double coutAcheteur;
double coutVendeur;
	public TauxDeChange() {
		super();
	}
	public TauxDeChange(String currency,double coutAcheteur,double coutVendeur){
		this.currency=currency;
		this.coutAcheteur=coutAcheteur;
		this.coutVendeur=coutVendeur;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getCoutAcheteur() {
		return coutAcheteur;
	}
	public void setCoutAcheteur(double coutAcheteur) {
		this.coutAcheteur = coutAcheteur;
	}
	public double getCoutVendeur() {
		return coutVendeur;
	}
	public void setCoutVendeur(double coutVendeur) {
		this.coutVendeur = coutVendeur;
	}
	@Override
	public String toString() {
		return "tauxDeChange [idTaux=" + idTaux + ", currency=" + currency
				+ ", coutAcheteur=" + coutAcheteur + ", coutVendeur="
				+ coutVendeur + "]";
	}
	
	

}
