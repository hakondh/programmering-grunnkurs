import static javax.swing.JOptionPane.*;
class Utregning {
	//Attributter
	public int teller;
	public int nevner;

	//Konstruktører
	public Utregning (int teller, int nevner) {
		if (nevner == 0){
			throw new IllegalArgumentException("Nevner kan ikke være null.");
		}
		this.teller = teller;
		this.nevner = nevner;
	}
	public Utregning (int teller) {
		this.teller = teller;
		this.nevner = 1;
	}

	//Metoder
		//Summere
	public void sum (Utregning b){
		if (this.nevner == b.nevner) {
			int tall1 = this.teller + b.teller;
			this.teller = tall1;
		}
		else {
			int tall1 = this.nevner*b.nevner;
			int tall2 = this.teller*b.nevner;
			int tall3 = this.teller*nevner;
			tall2+=tall3;
			this.teller = tall2;
			this.nevner = tall1;
		}
	}
		//Subtrahere
	public void differanse (Utregning b) {

		if (this.nevner == b.nevner) {
			int tall1 = this.teller-b.teller;
			this.teller = tall1;
		}
		else {
			int tall1 = this.nevner*b.nevner;
			int tall2 = this.teller*b.nevner;
			int tall3 = this.teller*nevner;
			tall2-=tall3;
			this.teller = tall2;
			this.nevner = tall1;
		}
	}

		//Multiplisere
	public void produkt (Utregning b) {
		int tall1 = this.teller*b.teller;
		int tall2 = this.nevner*b.nevner;
		this.teller = tall1;
		this.nevner = tall2;
	}
		//Dividere
	public void kvotient (Utregning b) {
		int tall1 = this.teller*b.nevner;
		int tall2 = this.nevner*b.teller;
		this.teller = tall1;
		this.nevner = tall2;
	}

	public String toString(){
		return(this.teller + "/" + this.nevner);
	}


}

class Brok {
	public static void main (String[] args) {

		int teller = Integer.parseInt(showInputDialog("Teller: "));
		int nevner = Integer.parseInt(showInputDialog("Nevner: "));
		int teller2 = Integer.parseInt(showInputDialog("Teller 2: "));
		int nevner2 = Integer.parseInt(showInputDialog("Nevner 2: "));

		Utregning brok1 = new Utregning(teller, nevner);
		Utregning brok2 = new Utregning(teller2, nevner2);

		int valg = Integer.parseInt(showInputDialog("Summer: 1 Subtraher: 2 Multipliser: 3 Divider: 4"));

		if (valg == 1) {
			brok1.sum(brok2);
			System.out.println("Svar: " + brok1.toString());
		}
		else if (valg == 2) {
			brok1.differanse(brok2);
			System.out.println("Svar: " + brok1.toString());
		}
		else if (valg == 3) {
			brok1.produkt(brok2);
			System.out.println("Svar: " + brok1.toString());
		}

		else if (valg == 4) {
			brok1.kvotient(brok2);
			System.out.println("Svar: " + brok1.toString());
		}
	}
}