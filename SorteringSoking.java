import static javax.swing.JOptionPane.*;
class SorteringSoking {
	public static void main (String[] args) {
		int[] tabell = {1, -4, 5, 10, 3, -100, -32};

		//Sortering:
		int minst;
		for (int k=0; k<tabell.length; k++) {
			minst=k;
			for (int i=k+1; i<tabell.length; i++) {
				if (tabell[i] < tabell[minst]) {
					minst= i;
				}
			}
			int hjelp=tabell[k];
			tabell[k]=tabell[minst];
			tabell[minst]=hjelp;
		}
		System.out.println("Sortert:");
		for (int p=0; p<tabell.length; p++) {
			System.out.println(tabell[p]);
		}

		int verdi = Integer.parseInt(showInputDialog("Verdi: "));
		int start=0;
		int slutt=tabell.length-1;
		while (start<=slutt) {
			int midten=(start+slutt)/2;
			if (tabell[midten] == verdi) {
				System.out.println("Verdien er funnet.");
				break;
			}
			else if (tabell[midten] < verdi) {
				start=midten+1;
			}
			else if (tabell[midten] > verdi) {
				slutt = midten-1;
			}
		}
		if(start>slutt) System.out.println("Verdien finnes ikke.");
	}
}
