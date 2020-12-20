import java.io.*;
import java.util.ArrayList;
class Sitte extends Tribune implements Serializable{
	private int [] antOpptatt;  // tabellst�rrelse: antall rader
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
	public Billett[] kj�pBilletter(int antBilletter){
		int antPerRad=(super.getKapasitet())/(antOpptatt.length);
		for (int i=0; i<antOpptatt.length; i++){
			if (super.kj�pBilletter(antBilletter).length<=(antPerRad-antOpptatt[i])){
				Billett[] billettene = super.kj�pBilletter(antBilletter);
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
	public Billett[] kj�pBilletter(String[] navn){
		//return kj�pBilletter(navn.length);
		int antPerRad=super.getKapasitet()/antOpptatt.length;
		Billett[] billetter = super.kj�pBilletter(navn);
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