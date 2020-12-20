import java.time.*;
class SoelvMedlem extends BonusMedlem {

	public SoelvMedlem(int medlNr, Personalia pers, LocalDate startTid, int poeng) {
		super(medlNr, pers, startTid);
		super.registrerPoeng(poeng);
	}

	@Override
	public void registrerPoeng(int poengene){
		int poengHeltall = (int) (poengene*1.2);
		super.registrerPoeng(poengHeltall);
	}
}