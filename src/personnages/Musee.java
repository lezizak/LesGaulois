package personnages;

public class Musee {
	private Trophee[] places = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		places[nbTrophee] = new Trophee(gaulois, equipement);
		nbTrophee += 1;
	}

	public String extraireInstructionsCaml(Musee musee) {
		String texte = "let musee = [";
		for(int i=0; i < nbTrophee; i++) {
			texte +=  "\n	\"" + places[i].donnerNom() + "\", " + "\"" + places[i].getEquipement() + "\";";
		}
		return texte+"\n]";
	}
	
	public static void main(String[] args) {
		Musee musee = new Musee();
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obelix", 80);
		musee.donnerTrophees(asterix, Equipement.CASQUE);
		musee.donnerTrophees(asterix, Equipement.BOUCLIER);
		musee.donnerTrophees(obelix, Equipement.CASQUE);
		System.out.println(musee.extraireInstructionsCaml(musee));
	}
}