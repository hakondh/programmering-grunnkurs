import static javax.swing .JOptionPane.*;

class Skuddaar	{

	public static void main(String[] args) {

	//Bruker oppgir år man vil sjekke om er et skuddår.

	String aarLest = showInputDialog("År: ");

	int aar = Integer.parseInt(aarLest);

	double aarRestDeltPaa100 = aar%100;

	double aarRestDeltPaa400 = aar%400;

	double aarRestDeltPaa4 = aar%4;

	//Kan året deles på 100 og i tillegg kan deles på 400 er det et skuddår.

	if (aarRestDeltPaa100 == 0.0 && aarRestDeltPaa400 == 0.0){
		showMessageDialog(null, aar + " er et skuddår.");

	}

	//Kan ikke året deles på 100, med det kan deles på 4, er det også et skuddår.

	else if (aarRestDeltPaa100 != 0.0 && aarRestDeltPaa4 == 0.0 ) {
		showMessageDialog(null, aar + " er et skuddår.");
	}

	//Om året ikke oppfyller noen av kriteriene ovenfor er det ikke et skuddår.

	else {
		showMessageDialog(null, aar + " er ikke et skuddår");
		}

	}

}

/* Testdata

aar = 1600
resultat = Skuddår.

aar = 3001
resultat = Ikke skuddår.

*/