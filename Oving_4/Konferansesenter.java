import java.util.ArrayList;

class Konferansesenter {
	public ArrayList<Rom> rommene = new ArrayList<Rom>();

	public boolean reserverRom(Tidspunkt fra, Tidspunkt til, int antallPersoner, String navn, String tlfNummer){
		for (int i=0; i < rommene.size(); i++){
			if (rommene.get(i).reservere(fra, til, antallPersoner, navn, tlfNummer)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Rom> getRommene () {
		return rommene;
	}

	public boolean regNyttRom(int romnummer, int størrelse) {
		//Sjekke om det finnes et rom med nummeret fra før:
		for (int i=0; i<rommene.size(); i++) {
			if (rommene.get(i)==null) {
				continue;
			}
			else if(rommene.get(i).getRomnr()==romnummer){
				return false;
			}
		}
		rommene.add(new Rom(romnummer, størrelse));
		return true;
	}

	public int getAntallRom(){
		return rommene.size();
	}

	public int finnRomnr(int indeks){
		//Ingen indeks
		if (indeks<0) {
			return -1;
		}
		else if (indeks>rommene.size()-1){
			return -1;
		}
		else if (rommene.get(indeks)==null) {
			return -1;
		}

		//Er indeks
		return rommene.get(indeks).getRomnr();
	}

	public int finnRomindeks(int romnr){
		for (int i=0; i < rommene.size(); i++){
			if (rommene.get(i)==null) {
				continue;
			}
			else if (rommene.get(i).getRomnr()==romnr) {
				return i;
			}
		}
		//Ingen indeks
		return -1;
	}

	public int getPlass (int indeks){
		return rommene.get(indeks).getStørrelse();
	}
	public static void main(String[] args) {

		//Konferansesenter TEST:
			Konferansesenter konferansesenter = new Konferansesenter();
			//Registrere et rom:
			System.out.println("True forventet: " + konferansesenter.regNyttRom(1, 10));
			//Reservere et rom:
			System.out.println("True forventet: " + konferansesenter.reserverRom(new Tidspunkt(200302011000L), new Tidspunkt(200302011100L), 4, "kunde", "93403693"));
			//Reservere et rom som er opptatt:
			System.out.println("False forventet: " + konferansesenter.reserverRom(new Tidspunkt(200302011000L), new Tidspunkt(200302011100L), 4, "kunde", "93403693"));
			//Antall rom:
			System.out.println("1 forventet: " + konferansesenter.getAntallRom());
			//Finn romnr gitt indeks:
			System.out.println("1 forventet: " + konferansesenter.finnRomnr(0));
			//Finn indeks gitt romnr:
			System.out.println("0 forventet: " + konferansesenter.finnRomindeks(1));
	}
}