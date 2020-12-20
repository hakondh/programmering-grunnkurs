import java.io.*;
abstract class Tribune implements Serializable{
	private final String tribunenavn;
	private final int kapasitet;
	private final int pris;

	public Tribune(String tribunenavn, int kapasitet, int pris){
		this.tribunenavn=tribunenavn;
		this.kapasitet=kapasitet;
		this.pris=pris;
	}

	public int getKapasitet(){
		return kapasitet;
	}

	public int getPris(){
		return pris;
	}

	public String getTribunenavn(){
			return tribunenavn;
	}

	abstract int finnAntallSolgteBilletter();

	public int finnInntekt(){
		return (getPris()*finnAntallSolgteBilletter());
	}

	public Billett[] kjøpBilletter(int antBilletter){
		if (finnAntallSolgteBilletter() + antBilletter>=getKapasitet()){
			return null;
		}
		Billett[] billettene = new Billett[antBilletter];
		return billettene;
	}

	public Billett[] kjøpBilletter(String[] navn){
		if (finnAntallSolgteBilletter() + navn.length >=getKapasitet()){
			return null;
		}
		Billett[] billettene = new Billett[navn.length];
		return billettene;
	}

	public String toString(){
		return "Tribune: " + tribunenavn + "\nKapasitet: " + kapasitet + "\nAntall solgte billetter: " +  finnAntallSolgteBilletter() + "\nInntekt: " + finnInntekt() +"\n";
	}
}