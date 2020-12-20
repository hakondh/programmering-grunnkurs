import static javax.swing.JOptionPane.*;
import java.util.Arrays;

class Tekstanalyse {
	public int[] antallTegn = new int[30];
	public String tekst;
	public int forskjellige;
	public int antall;
	public double prosentIkkeBokstav;
	public double totalt;
	public int antallBestemtBokstav;
	public String[] bokstaver = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å"};

	Tekstanalyse(String tekst) {
		this.tekst = tekst;
	}

	public void tellOpp () {
		for (int i=0; i<tekst.length(); i++) {
			char tegn = tekst.charAt(i);
			int verdi = tegn;
			if (verdi>=97 && verdi<=122){
				antallTegn[verdi-97]++;
			}
			else if (verdi>=65 && verdi<=90){
				antallTegn[verdi-65]++;
			}
			else if (verdi == 230 || verdi == 198) {
				antallTegn[26]++;
			}
			else if (verdi == 248 || verdi == 216) {
				antallTegn[27]++;
			}
			else if (verdi == 229 || verdi == 197) {
				antallTegn[28]++;
			}
			else {
				antallTegn[29]++;
			}
		}
	}

	public int getAntallForskjellige () {
			for (int i=0; i<29; i++){
				if (antallTegn[i] != 0) {
					forskjellige++;
				}
			}
			if (forskjellige == 1) {
				return(0);
			}
			else {
				return(forskjellige);
			}
	}
	public int getAntallBokstaver () {
		for (int i=0; i<29; i++){
			antall+=antallTegn[i];
		}
		return(antall);
	}

	public double getIkkeBokstaver () {
		for (int i=0; i<30; i++){
			totalt+=antallTegn[i];
		}
		double prosentdel = ((antallTegn[29])/totalt)*100;
		return(prosentdel);
	}

	public int getHvorMange (int unicode){
		if (unicode>=97 && unicode<=122){
			antallBestemtBokstav = antallTegn[unicode-97];
		}
		else if (unicode>=65 && unicode<=90){
			antallBestemtBokstav = antallTegn[unicode-65];
		}
		else if (unicode == 230 || unicode == 198) {
			antallBestemtBokstav = antallTegn[26];
		}
		else if (unicode == 248 || unicode == 216) {
			antallBestemtBokstav = antallTegn[27];
		}
		else if (unicode == 229 || unicode == 197){
			antallBestemtBokstav = antallTegn[28];
		}
		return(antallBestemtBokstav);
	}

	public String getOftest () {
		int storste = 0;
		for (int i=0; i<antallTegn.length-2; i++) {
			if (antallTegn[i]>antallTegn[storste]) {
				storste = i;
			}
		}
		String utskrift = "Bokstaven(e) som forekommer oftest: " + bokstaver[storste];

		for (int i=storste+1; i<=antallTegn.length -2; i++) {
			if (antallTegn[i]==antallTegn[storste]) {
				utskrift+= ", " + bokstaver[i];
			}
		}
		return(utskrift);
	}
}

class SkrivInnTekst {
	public static void main (String[] args) {
		boolean kjor = true;

		while (kjor == true) {
			//Skrive inn tekst
			String tekst = showInputDialog("Tekst: ");
			Tekstanalyse utfor = new Tekstanalyse(tekst);

			//Telle opp hver bokstav og legge i array
			utfor.tellOpp();

			//Finne antallet forskjellige bokstaver
			int antallForskjellige = utfor.getAntallForskjellige();
			System.out.println("Antall forskjellige: " + antallForskjellige);

			//Finne totalt antall bokstaver
			int totalt = utfor.getAntallBokstaver();
			System.out.println("Totalt antall bokstaver: " + totalt);

			//Finne prosentdel som ikke er bokstaver
			double prosent = utfor.getIkkeBokstaver();
			System.out.println("Del av teksten som ikke er bokstaver: " + prosent + " %");

			//Finne antallet av en bestemt bokstav
			String finnDenne = showInputDialog("Finn antall av bokstaven: ");
			char tegn = finnDenne.charAt(0);
			int unicode = tegn;
			int bestemtBokstav = utfor.getHvorMange(unicode);
			System.out.println("Antall av bokstaven " + finnDenne + ": " + bestemtBokstav);

			//Finne den/de bokstav(ene) det er flest av
			String flest = utfor.getOftest();
			System.out.println(flest);

			int fortsett = Integer.parseInt(showInputDialog("Skriv 1 for å avslutte, 2 for å fortsette"));
			if (fortsett == 1) {
				kjor = false;
			}
			else {
				continue;
			}
		}
	}
}