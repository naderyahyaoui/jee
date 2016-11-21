package Domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Budgetisation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int idBudgetisation;
	
	double depot;
	double credit;
	double tauxInteret;
	String mois;
	String date;
	double montant;
	double budget;
	String partenaire;
	public double getDepot() {
		return depot;
	}
	public void setDepot(double depot) {
		this.depot = depot;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getTauxInteret() {
		return tauxInteret;
	}
	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getPartenaire() {
		return partenaire;
	}
	public void setPartenaire(String partenaire) {
		this.partenaire = partenaire;
	}
	public Budgetisation(double depot, double credit, double tauxInteret,
			String mois, String date, double montant, double budget,
			String partenaire) {
		super();
		this.depot = depot;
		this.credit = credit;
		this.tauxInteret = tauxInteret;
		this.mois = mois;
		this.date = date;
		this.montant = montant;
		this.budget = budget;
		this.partenaire = partenaire;
	}
	public Budgetisation(){
		super();
	}
	@Override
	public String toString() {
		return "Budgetisation [idBudgetisation=" + idBudgetisation + ", depot="
				+ depot + ", credit=" + credit + ", tauxInteret=" + tauxInteret
				+ ", mois=" + mois + ", date=" + date + ", montant=" + montant
				+ ", budget=" + budget + ", partenaire=" + partenaire + "]";
	}
	
	
	
	
	
}
