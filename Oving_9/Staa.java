import java.io.*;
class Staa extends Tribune implements Serializable{
	private int antSolgteBilletter;

	public Staa(String tribunenavn, int kapasitet, int pris){
		super(tribunenavn, kapasitet, pris);

	}

	public int finnAntallSolgteBilletter() {
		return antSolgteBilletter;
	}

	@Override
	public Billett[] kjøpBilletter(int antBilletter){
		Billett[] billettene = super.kjøpBilletter(antBilletter);
		for (int i=0; i<antBilletter; i++){
			billettene[i]=new StaaplassBillett(super.getTribunenavn(), super.getPris());
		}
		antSolgteBilletter+=antBilletter;
		return billettene;
	}

	@Override
	public Billett[] kjøpBilletter(String[] navn){
		Billett[] billettene = super.kjøpBilletter(navn.length);
		for (int i=0; i<navn.length; i++){
			billettene[i]=new  StaaplassBillett(super.getTribunenavn(), super.getPris());
		}
		antSolgteBilletter+=navn.length;
		return billettene;
	}
}