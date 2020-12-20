import static javax.swing.JOptionPane.*;

class NyString {
	public String tekst = " ";


	NyString(String tekst) {
		this.tekst = tekst;
	}

	public String forkorting () {
		String[] ord = tekst.split(" ");
		String forkortelse = " ";
		for (int i = 0; i < ord.length; i++) {
			forkortelse+= String.valueOf(ord[i].charAt(0));
		}
		return(forkortelse);
	}

	public String fjern (String bokstav) {
		String nyTekst = tekst.replace(bokstav, "");
		//int pos = 0;
		//(while pos != -1) {
			//int pos = tekst.indexOf("e", pos+1)

		//}
		return(nyTekst);
	}
}

class Tekstendrer {
	public static void main (String[] args) {
		boolean kjor = true;
		while (kjor == true) {
			int valg = Integer.parseInt(showInputDialog("1. Forkorting \n 2. Fjern tegn \n 3. Avslutt"));

			if (valg == 1) {
				String tekst = showInputDialog("Skriv inn teksten:");
				NyString utfor = new NyString(tekst);
				String resultat = utfor.forkorting();
				System.out.println(resultat);
			}
			else if (valg == 2) {
				String tekst = showInputDialog("Skriv inn teksten:");
				NyString utfor = new NyString(tekst);
				String bokstav = showInputDialog("Bokstav du vil fjerne: " );
				String resultat = utfor.fjern(bokstav);
				System.out.println(resultat);
			}
			else {
				kjor = false;
			}
		}
	}
}