import java.util.*;
import java.time.*;

class Medlemsarkiv {
	public ArrayList<BonusMedlem> medlemmene = new ArrayList<BonusMedlem>();

	public int nyMedlem(Personalia pers, LocalDate innmeldt){
		int medlNr = finnLedigNr();
		medlemmene.add(new BasicMedlem(medlNr, pers, innmeldt));
		return medlNr;
	}

	public Object getMedlem(int indeks){
		return medlemmene.get(indeks);
	}

	private int finnLedigNr(){
		Random random = new Random();
		int randomNr=0;
		boolean found=false;
		while(!found){
			randomNr=random.nextInt(200)+1;;
			found=true;
			for (int i=0; i<medlemmene.size(); i++){
				if (randomNr==medlemmene.get(i).getMedlnr()) {
					found=false;
					break;
				}
			}
		}
		return randomNr;
	}

	public int finnPoeng(int medlemsnummer, String passord){
		for (int i=0; i<medlemmene.size(); i++){
			if(medlemmene.get(i).getMedlnr()==medlemsnummer && medlemmene.get(i).okPassord(passord)) return medlemmene.get(i).getPoeng();
		}
		return -1;
	}

	public boolean registrerPoeng(int medlemsnummer, int poeng){
		for (int i=0; i<medlemmene.size(); i++){
			if (medlemmene.get(i).getMedlnr()==medlemsnummer){
				medlemmene.get(i).registrerPoeng(poeng);
				return true;
			}
		}
		return false;
	}

	public void sjekkMedlemmer(){
		for (int i=0; i<medlemmene.size(); i++){
			if (medlemmene.get(i) instanceof BasicMedlem) {
				if (medlemmene.get(i).finnKvalPoeng(LocalDate.now())>=75000){
					medlemmene.set(i, new GullMedlem(medlemmene.get(i).getMedlnr(), medlemmene.get(i).getPers(), medlemmene.get(i).getInnmeldtDato(), medlemmene.get(i).getPoeng()));
				 }
				 else if (medlemmene.get(i).finnKvalPoeng(LocalDate.now())>=25000) {
				 	medlemmene.set(i, new SoelvMedlem(medlemmene.get(i).getMedlnr(), medlemmene.get(i).getPers(), medlemmene.get(i).getInnmeldtDato(), medlemmene.get(i).getPoeng()));
				}
			}
			else if (medlemmene.get(i) instanceof SoelvMedlem) {
				if (medlemmene.get(i).finnKvalPoeng(LocalDate.now())>=75000){
					medlemmene.set(i, new GullMedlem(medlemmene.get(i).getMedlnr(), medlemmene.get(i).getPers(), medlemmene.get(i).getInnmeldtDato(), medlemmene.get(i).getPoeng()));
				 }
			}
		}
	}
}