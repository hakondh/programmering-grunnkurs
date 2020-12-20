import java.util.Calendar;
import java.time.LocalDate;
class CalendarTest{
	public static void main(String[] args){
		/*Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);

		System.out.println(day + " "+ month +" "+ year);*/

		LocalDate birth = new LocalDate(1998, 1, 7);
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(birt, now);
		System.out.println(age);
	}
}