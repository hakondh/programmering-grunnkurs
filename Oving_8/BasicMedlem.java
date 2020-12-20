import java.time.*;
class BasicMedlem extends BonusMedlem {

	public BasicMedlem(int medlNr, Personalia pers, LocalDate startTid) {
		super(medlNr, pers, startTid);
	}

	@Override
	public void registrerPoeng(int poengene){
		super.registrerPoeng(poengene);
	}
}