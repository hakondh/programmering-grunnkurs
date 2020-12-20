import static javax.swing.JOptionPane.*;

class BilligstKjottdeig {

	public static void main (String [] args) {

		double kjottdeigA = Double.parseDouble(showInputDialog("Pris kjøttdeig A: "));
		double gramA = Double.parseDouble(showInputDialog("Gram kjøttdeig A: "));

		double kjottdeigB = Double.parseDouble(showInputDialog("Pris kjøttdeig B: "));
		double gramB = Double.parseDouble(showInputDialog("Gram kjøttdeig B: "));

		double prisPerGramA = kjottdeigA / gramA;
		double prisPerGramB = kjottdeigB / gramB;

	if (prisPerGramA < prisPerGramB) {
			showMessageDialog(null, "Kjøttdeig av merke A er billigst.");
		}

		else if (prisPerGramB < prisPerGramA) {
			showMessageDialog(null, "Kjøttdeig av merke B er billigst.");
		}
		else {
			showMessageDialog(null, "Disse to merkene er like billige!");
		}
	}
}

/* Testdata

Kjører med opprinnelige verdier.
Resultat = Kjøttdeig B er billigst.

Kjører med kjottdeigB = 49.50
Resultat = Kjøttdeig A er billigst.

Kjører med A og B like
Resultat = Diesse to merkene er like billige.

*/