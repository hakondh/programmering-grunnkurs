import static javax.swing.JOptionPane.*;
class Teksttjeneste {
	public String tekst = " ";

	Teksttjeneste (String tekst) {
		this.tekst = tekst;
	}

	public int antallOrd () {
		String[] ord = tekst.split(" ");
		int antallOrd = ord.length;
		return(antallOrd);
	}

	public double gjennomsnittligL () {
		String[] ord = tekst.split(" ");
		double sum=0;
		for (int i = 0; i<ord.length; i++) {
			sum += ord[i].length();
		}
		double gjennomsnitt = sum/ord.length;
		return(gjennomsnitt);
	}
	public double gjennomsnittligAntallOrdPeriode () {
		String[] perioder = tekst.split("[.!:?]");
		double antallPerioder = perioder.length;

		String[] ord = tekst.split(" ");
		double antallOrd = ord.length;

		double gjennomsnittOPP = antallOrd/antallPerioder;
		return(gjennomsnittOPP);
		}
	public String byttUt (String fjern, String leggTil) {
		String nyTekst = tekst.replace(fjern, leggTil);
		return(nyTekst);
	}
	public String originalTekst () {
		return(tekst);
	}
	public String originalTekstStore () {
			String store = tekst.toUpperCase();
			return(store);
	}

}

class Tekstbehandler {
	public static void main (String[] args) {
		String tekst = showInputDialog("Tekst: ");
		Teksttjeneste utfor = new Teksttjeneste(tekst);

		int antall = utfor.antallOrd();
		System.out.println("Antall ord: " + antall);

		double gjennomsnittet = utfor.gjennomsnittligL();
		System.out.println("Gjennomsnittlig ordlengde: " + gjennomsnittet);

		double gjennsomsnittOrdPerPeriode = utfor.gjennomsnittligAntallOrdPeriode();
		System.out.println("Gjennomsnittlig antall ord per periode: " + gjennsomsnittOrdPerPeriode);

		String fjern = showInputDialog("Fjern: ");
		String leggTil = showInputDialog("Legg til: ");
		String nyTekst = utfor.byttUt(fjern, leggTil);
		System.out.println(nyTekst);

		String denOriginale = utfor.originalTekst();
		System.out.println(denOriginale);

		String denOriginaleStore = utfor.originalTekstStore();
		System.out.println(denOriginaleStore);
	}
}
