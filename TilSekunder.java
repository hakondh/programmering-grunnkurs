import static javax.swing .JOptionPane.*;

class TilSekunder {

	public static void main(String[] args) {

		//Viser brukeren hva man skal legge inn.

		String timerLest = showInputDialog("Timer: ");
		String minutterLest = showInputDialog("Minutter: ");
		String sekunderLest = showInputDialog("Sekunder: ");

		//Legger inn brukerens verdier som variabler.

		int timer = Integer.parseInt(timerLest);
		int minutter = Integer.parseInt(minutterLest);
		int sekunder = Integer.parseInt(sekunderLest);

		//Utregningen utføres, så lenge verdiene brukeren har lagt inn er større eller lik null. Resultat skrives ut.

		if (timer >= 0 && minutter >= 0 && sekunder >= 0) {

			int timerTilSekunder = timer * 60 * 60;
			int minutterTilSekunder = minutter * 60;
			int tidISekunder = timerTilSekunder + minutterTilSekunder + sekunder;

			showMessageDialog(null, timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder er totalt " + tidISekunder + " sekunder");
		}

		//Har brukeren lagt inn en verdi som er mindre enn null kommer det en feilmelding.

		else {

		showMessageDialog(null, "Tiden du har satt inn er ugyldig!");

		}
	}
}

/* Testdata

Timer: 1
Minutter: 2
Sekunder: 3
Resultat: 3723

Timer: 1.2
Minutter: 2.3
Sekunder: 3.4
Resultat: 4461.4

Timer: 1
Minutter: 0
Sekunder: 3
Resultat: 3603

Timer: -1
Minutter: 2
Sekunder: 3
Resultat: Tiden du har satt inn er ugyldig!

*/


