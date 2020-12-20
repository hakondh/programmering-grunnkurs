import static javax.swing .JOptionPane.*;

class TommerTilCentimeter {

	public static void main(String[] args) {

		//Bruker oppgir verdien av tommer som vedkommende vil konvertere til centimeter.

		String tommerLest = showInputDialog("Tommer: ");

		double tommer = Double.parseDouble(tommerLest);

		//Faktoren som brukes for å konvertere til centimeter

		final double TOMMER_FAKTOR = 2.54;

		//Her utføres utregningen, så lenge verdien brukeren har oppgitt møter kravet om å være mindre eller lik null. Deretter skrives det ut en melding med resultat.


	if (tommer >= 0.0) {

		double centimeter = TOMMER_FAKTOR * tommer;

		showMessageDialog(null, tommer + " tommer er " + centimeter + " centimeter.");
	}
	else {
		showMessageDialog(null, "Verdien lagt inn for tommer er ugyldig.");
		}
	}
}

/* Testdata

Tommer: 1
Resultat: 2.54

Tommer: -1
Resultat: Verdien lagt inn for tommer er ugyldig.

*/

