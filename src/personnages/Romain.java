package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert(force > 0):"la force d'un Romain est toujours positive";
	}
	
	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert(force > 0):"la force d'un Romain est positive";
		int forceInit = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert(force < forceInit):"la force d'un Romain a diminué";
	}

	public void sEquiper (Equipement equipement) {
		switch(nbEquipement){
			case 2:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1:
				if (equipements[0] != equipement) {
					System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
					equipements[nbEquipement] = equipement;
					nbEquipement += 1;
				} else 
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
				break;
			case 0:
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
				equipements[nbEquipement] = equipement;
				nbEquipement += 1;
				break;
		}
	}
	
///////////main
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		minus.parler("Bonjour !");
		minus.recevoirCoup(7);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
}