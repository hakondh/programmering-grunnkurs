import static javax.swing.JOptionPane.*;
class Testing {
	public static void main (String[] args) {
		/*int [] tabell = {10, -3, -2, 32, 4};
		//Sortering
		for (int k=0; k<tabell.length; k++) {
			int minst=k;
			for (int i=k+1; i<tabell.length; i++) {
				if(tabell[i] < tabell[minst]) minst=i;
			}
			int hjelp = tabell[k];
			tabell[k] = tabell[minst];
			tabell[minst] = hjelp;
		}
		System.out.println("Sortert");
		for (int m=0; m<tabell.length; m++){
			System.out.println(tabell[m]);
		}
		//Binærsøk
		int verdi=Integer.parseInt(showInputDialog("Verdi: "));
		int start=0;
		int slutt=tabell.length - 1;
		while (start<=slutt) {
			int midten = (start+slutt)/2;
			if (verdi==tabell[midten]) {
				System.out.println("Verdien er funnet.");
				break;
			}
			else if (verdi<tabell[midten]){
				slutt=midten-1;
			}
			else if (verdi>tabell[midten]){
				start=midten+1;
			}
		}
		if (start>slutt) System.out.println("Ikke funnet.");
		*/
	int[] tabell = new int[1];
	int tall = 1;
	tall--;

	if (tabell[tall]==tall) {
		System.out.println("JAUAJAUA");
	}
	else {
		System.out.println("bBBBBBBBBBBbbb");
	}

	}
}

