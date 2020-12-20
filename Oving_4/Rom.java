import java.util.ArrayList;

class Rom {
	private ArrayList<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();
	private int romnr;
	private int størrelse;
	private int antallReservasjoner;

	Rom(int romnr, int størrelse){
		this.romnr=romnr;
		this.størrelse=størrelse;
	}

	public int getRomnr(){
		return romnr;
	}

	public int getStørrelse(){
		return størrelse;
	}

	public int getAntallReservasjoner(){
		return antallReservasjoner;
	}

	public boolean reservere (Tidspunkt fra, Tidspunkt til, int antallPersoner, String navn, String tlfNummer){
		//Sjekke om rommet er stort nok:
		if(antallPersoner>størrelse) return false;
		//Sjekke om det ikke er noen reservasjoner i dette rommet:
		if (reservasjoner.size()==0) {
			Kunde kunde= new Kunde(navn, tlfNummer);
			reservasjoner.add(new Reservasjon(fra,til,kunde));
			antallReservasjoner++;
			return true;
		}
		for (int i=0; i < reservasjoner.size(); i++) {
			if(reservasjoner.get(i)==null) {
				continue;
			}
			else {
				if (reservasjoner.get(i).overlapp(fra, til)) {
					return false;
				}
			}
		}
		Kunde kunde= new Kunde(navn, tlfNummer);
		reservasjoner.add(new Reservasjon(fra,til, kunde));
		antallReservasjoner++;
		return true;
	}

	public String[] reservasjonsInfo (){
		String[] reservasjonene = new String[antallReservasjoner];
		for (int i=0; i<antallReservasjoner; i++){
		 	reservasjonene[i]=reservasjoner.get(i).toString();
		}
		return reservasjonene;
	}

	public static void main(String[] args) {
		Rom test = new Rom(1, 4);
		//Teste reservasjon uten overlapp:
		System.out.println("True forventet: " + test.reservere(new Tidspunkt(200302011000L), new Tidspunkt(200302011100L), 4, "kunde", "93403693"));
		//Teste reservasjon med overlapp:
		System.out.println("False forventet: " + test.reservere(new Tidspunkt(200302011000L), new Tidspunkt(200302011100L), 5, "kunde2", "93403694"));
		//Teste reservasjon med tidspunkt som ikke stemmer:
		System.out.println("False forventet: " + test.reservere(new Tidspunkt(200302011100L), new Tidspunkt(200302011000L), 5, "kunde3", "93403695"));
		//Teste å finne romnr:
		System.out.println("1 forventet: " + test.getRomnr());
		//Teste å finne størrelse:
		System.out.println("4 forventet: " + test.getStørrelse());

	}

}