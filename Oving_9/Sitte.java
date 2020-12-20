import java.io.*;
import java.util.ArrayList;
class Sitte extends Tribune implements Serializable{
	private int [] antOpptatt;  // tabellstørrelse: antall rader
	//Fiks plasseringer

	public Sitte(String tribunenavn, int kapasitet, int pris, int antallRader){
		super(tribunenavn, kapasitet, pris);
		antOpptatt=new int[antallRader];
	}

	public int finnAntallSolgteBilletter() {
		int solgte=0;
		for (int i=0; i<antOpptatt.length; i++){
			solgte+=antOpptatt[i];
		}
		return solgte;
	}

	@Override
	public Billett[] kjøpBilletter(int antBilletter){
		int antPerRad=(super.getKapasitet())/(antOpptatt.length);
		for (int i=0; i<antOpptatt.length; i++){
			if (super.kjøpBilletter(antBilletter).length<=(antPerRad-antOpptatt[i])){
				Billett[] billettene = super.kjøpBilletter(antBilletter);
				for (int h=0; h<antBilletter; h++){
					billettene[h]=new SitteplassBillett(super.getTribunenavn(), super.getPris(), i, antOpptatt[i]+h);
				}
				antOpptatt[i]+=antBilletter;
				return billettene;
			}
		}
		return null;
	}

	@Override
	public Billett[] kjøpBilletter(String[] navn){
		//return kjøpBilletter(navn.length);
		int antPerRad=super.getKapasitet()/antOpptatt.length;
		Billett[] billetter = super.kjøpBilletter(navn);
		for (int i=0; i<antOpptatt.length; i++){
			if (billetter.length<=(antPerRad-antOpptatt[i])){
				for (int h=0; h<navn.length; h++){
					billetter[h]=new SitteplassBillett(super.getTribunenavn(), super.getPris(), i, antOpptatt[i]+h);
				}
				return billetter;
			}
		}
		return null;
	}

}