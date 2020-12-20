import java.io.*;
class VIP extends Sitte implements Serializable{
	private String[][] tilskuer; // tabellstørrelse: antall rader * antall plasser pr rad

	public VIP(String tribunenavn, int kapasitet, int pris, int antallRader, int plasser){
		super(tribunenavn, kapasitet, pris, antallRader);
		tilskuer = new String[antallRader][plasser];
	}

	public int finnAntallSolgteBilletter() {
		int solgte=0;
		for (int i=0; i<tilskuer.length; i++){
			for (int k=0; k<tilskuer[i].length; k++){
				if (tilskuer[i][k]!=null)solgte++;
			}
		}
		return solgte;
	}

	@Override
	public Billett[] kjøpBilletter(int antBilletter){
		return null;
	}

	@Override
	public Billett[] kjøpBilletter(String[] navn){
		for (int i=0; i<tilskuer.length; i++){
			int opptatte=0;
			for (int k=0; k<tilskuer[i].length; k++){
				if (tilskuer[i][k]!=null){
					opptatte++;
				}
			}
			if ((tilskuer[i].length-opptatte)>(navn.length)){
				Billett[] billetter = new Billett[navn.length];
				for (int h=0; h<navn.length; h++){
					for (int g=0; g<navn.length; g++){
						tilskuer[i][opptatte+g]=navn[g];
					}
					billetter[h]=new SitteplassBillett(super.getTribunenavn(), super.getPris(), i, opptatte+h);
				}
				return billetter;
			}
		}
		return null;
	}

}