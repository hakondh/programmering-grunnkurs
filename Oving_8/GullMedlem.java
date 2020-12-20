import java.time.*;
class GullMedlem extends BonusMedlem {

	public GullMedlem(int medlNr, Personalia pers, LocalDate startTid, int poeng) {
		super(medlNr, pers, startTid);
		super.registrerPoeng(poeng);
	}

	@Override
	public void registrerPoeng(int poengene){
		int poengHeltall = (int) (poengene*1.5);
		super.registrerPoeng(poengHeltall);
	}
}