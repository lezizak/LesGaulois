package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");

	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est "+ forcePotion +" fois d�cupl�e.");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
////////////// TP3

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] listEq = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; listEq != null && i < listEq.length; i++, nbTrophees++) {
			trophees[nbTrophees] = listEq[i];
		}
	}	
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees == 0) return;
		String texte = "Je donne au musee tous mes trophees :";
		for(int i=0; i < nbTrophees; i++) {
			musee.donnerTrophees(this, trophees[i]);
			texte += "\n-" + trophees[i];
		}
		parler(texte);
	}
	


///////////main
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour !");
		obelix.parler("Salut Asterix !");
		Romain minus = new Romain("Minus", 6);
		asterix.frapper(minus);
		asterix.boirePotion(5);

	}
}