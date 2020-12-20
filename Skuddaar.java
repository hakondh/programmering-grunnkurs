import static javax.swing .JOptionPane.*;

class Skuddaar	{

	public static void main(String[] args) {

	//Bruker oppgir �r man vil sjekke om er et skudd�r.

	String aarLest = showInputDialog("�r: ");

	int aar = Integer.parseInt(aarLest);

	double aarRestDeltPaa100 = aar%100;

	double aarRestDeltPaa400 = aar%400;

	double aarRestDeltPaa4 = aar%4;

	//Kan �ret deles p� 100 og i tillegg kan deles p� 400 er det et skudd�r.

	if (aarRestDeltPaa100 == 0.0 && aarRestDeltPaa400 == 0.0){
		showMessageDialog(null, aar + " er et skudd�r.");

	}

	//Kan ikke �ret deles p� 100, med det kan deles p� 4, er det ogs� et skudd�r.

	else if (aarRestDeltPaa100 != 0.0 && aarRestDeltPaa4 == 0.0 ) {
		showMessageDialog(null, aar + " er et skudd�r.");
	}

	//Om �ret ikke oppfyller noen av kriteriene ovenfor er det ikke et skudd�r.

	else {
		showMessageDialog(null, aar + " er ikke et skudd�r");
		}

	}

}

/* Testdata

aar = 1600
resultat = Skudd�r.

aar = 3001
resultat = Ikke skudd�r.

*/