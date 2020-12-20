import static javax.swing.JOptionPane.*;

class ValutaKlasse {
	/* Attributter */
	private final double valuta;
	public double brukerbelop;

	/* Kontstruktør */
	public ValutaKlasse(double valuta, double brukerbelop) {
		this.valuta = valuta;
		this.brukerbelop = brukerbelop;
	}

	/*Metode: Fra andre valuter til norsk */
	public double getTilNOK () {
		return (brukerbelop*valuta);
	}

	/* Metode: Fra norsk valuta til andre */
	public double getFraNOK () {
		return (brukerbelop/valuta);
	}
}

class Valuta {
	public static void main (String [] args) {
		int valutaType = 0;

		while (valutaType != 4) {
			valutaType = Integer.parseInt(showInputDialog("Velg valuta: \n 1: Dollar \n 2: Euro \n 3: Svenske kroner \n 4: avslutt"));

			if (valutaType != 4) {
				double brukerbelop = Double.parseDouble(showInputDialog("Beløp: "));

				ValutaKlasse dollar = new ValutaKlasse(7.85, brukerbelop);
				ValutaKlasse euro = new ValutaKlasse(9.4, brukerbelop);
				ValutaKlasse svenskeKroner = new ValutaKlasse(0.98, brukerbelop);

				if (valutaType == 1) {
					double fraDollarTilNOK = dollar.getTilNOK();
					showMessageDialog(null, "Dette er " + fraDollarTilNOK + " NOK");
				}

				else if (valutaType == 2) {
					double fraEuroTilNOK = euro.getTilNOK();
					showMessageDialog(null, "Dette er " + fraEuroTilNOK +  " NOK");
				}

				else if (valutaType == 3) {
					double fraSvenskeKronerTilNOK = svenskeKroner.getTilNOK();
					showMessageDialog(null, "Dette er " + fraSvenskeKronerTilNOK +  " NOK");
				}
			}

			else {
				continue;
			}
		}
	}
}