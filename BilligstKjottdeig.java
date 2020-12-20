import static javax.swing.JOptionPane.*;

class BilligstKjottdeig {

	public static void main (String [] args) {

		double kjottdeigA = Double.parseDouble(showInputDialog("Pris kj�ttdeig A: "));
		double gramA = Double.parseDouble(showInputDialog("Gram kj�ttdeig A: "));

		double kjottdeigB = Double.parseDouble(showInputDialog("Pris kj�ttdeig B: "));
		double gramB = Double.parseDouble(showInputDialog("Gram kj�ttdeig B: "));

		double prisPerGramA = kjottdeigA / gramA;
		double prisPerGramB = kjottdeigB / gramB;

	if (prisPerGramA < prisPerGramB) {
			showMessageDialog(null, "Kj�ttdeig av merke A er billigst.");
		}

		else if (prisPerGramB < prisPerGramA) {
			showMessageDialog(null, "Kj�ttdeig av merke B er billigst.");
		}
		else {
			showMessageDialog(null, "Disse to merkene er like billige!");
		}
	}
}

/* Testdata

Kj�rer med opprinnelige verdier.
Resultat = Kj�ttdeig B er billigst.

Kj�rer med kjottdeigB = 49.50
Resultat = Kj�ttdeig A er billigst.

Kj�rer med A og B like
Resultat = Diesse to merkene er like billige.

*/