import static javax.swing .JOptionPane.*;

class SekunderTilTMS {

	public static void main(String[] args) {

		//Bruker skriver inn antall sekunder, dette blir så lagt inn som en variabel.

		String sekunderLest = showInputDialog("Sekunder: ");
		int sekunderOriginalt = Integer.parseInt (sekunderLest);

		//Har brukeren lagt inn negativ verdi kommer det en feilmelding.

		if (sekunderOriginalt < 0) {
			showMessageDialog(null, "Verdien du har lagt inn er ikke gyldig.");
		}

		//Om sekundene oppgitt er høyere eller lik 3600 tas timer med i utregningen.

		else if (sekunderOriginalt >= 3600) {

			int timerRest = sekunderOriginalt%3600;
			int timer = (sekunderOriginalt - timerRest) / 3600;

			int minutterRest = timerRest%60;
			int minutter = (timerRest - minutterRest) / 60;

			int sekunder = minutterRest;

			showMessageDialog(null, sekunderOriginalt + " sekunder er " + timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder.");

	}

		//Om det er mindre enn 3600 sekunder, men mer en 60, gjøres utregning uten hensyn til timer.

		else if (sekunderOriginalt >= 60 ) {

			int minutterRest = sekunderOriginalt%60;
			int minutter = (sekunderOriginalt - minutterRest) / 60;

			int sekunder = sekunderOriginalt%60;

			showMessageDialog(null, sekunderOriginalt + " sekunder er "  + minutter + " minutter og " + sekunder + " sekunder.");

		}

		//Om det er mindre enn 60 sekunder, kan man skrive ut det brukeren har oppgitt, ettersom at det ikke kan omgjøres til minutter eller timer.

		else if (sekunderOriginalt < 60 && sekunderOriginalt >= 0) {

			showMessageDialog(null, sekunderOriginalt + " sekunder er " + sekunderOriginalt + " sekunder.");

		}
	}
}

/* Testdata

Sekunder: 7000
Resultat: 1 time 56 minutter 40 sekunder

Sekunder: 3000
Resultater: 50 minutter

Sekunder: 30
Resultater: 30 sekunder

Sekunder: -7000
Resultat: Verdien du har lagt inn er ikke gyldig.

*/

