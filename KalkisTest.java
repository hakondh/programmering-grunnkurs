import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class KalkisTest {

    Kalkis instance; // Deklarerer Kalkis-objektet her.

    @BeforeClass
    public static void setUpClass() throws Exception {
		// database-innlogging
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
      // database.logut
    }

    @Before
    public void setUp() {
		/* oppretter nytt Kalkis-objekt her, alternativt kan vi opprette et nytt objekt i den enkelte test-metoden */
		instance = new Kalkis();
    }

    @After
    public void tearDown() {
		instance = null;
    }

    @Test
    public void testPluss() {
        System.out.println("pluss");
        double x = 0.0;
        double y = 0.0;
        double delta  = 0.0001; // hvor noyaktig like maa tallene vaere?
        double expResult = 0.0;
        double result = instance.pluss(x, y);
        assertEquals(expResult, result, delta);
    }

    @Test
    public void testMinus() {
        System.out.println("minus");
        double x = 0.0;
        double y = 0.0;
        double delta  = 0.0001; // hvor noyaktig like maa tallene vaere?
        double expResult = 0.0;
        double result = instance.minus(x, y);
        assertEquals(expResult, result, delta);
    }

    @Test
    public void testGange() {
        System.out.println("gange");
        double x = 0.0;
        double y = 0.0;
        double delta  = 0.0001; // hvor noyaktig like maa tallene vaere?
        double expResult = 0.0;
        double result = instance.gange(x, y);
        assertEquals(expResult, result, delta);
   }

	// flere feiltester i samme metode forer til at kun forste feil rapporteres.
	// bor vurdere aa dele opp i kun en test pr testmetode
    @Test
    public void testDivisjon() {
        System.out.println("divisjon");
        double x = 0.0;
        double y = 0.0;
        double delta  = 0.0001; // hvor noyaktig like maa tallene vaere?
        double expResult = Double.NaN;
        double result = instance.divisjon(x, y);
        assertEquals(expResult, result, delta);  // test 1

        x = 0.0;
        y = 1.0;
        expResult = 0.0;
        result = instance.divisjon(x, y);
        assertEquals(expResult, result, delta); // test 2

        x = 1.0;
        y = 0.0;
        expResult = Double.POSITIVE_INFINITY;
        result = instance.divisjon(x, y);
        assertEquals(expResult, result, delta);  // test 3

        x = 1.0;
        y = 1.0;
        expResult = 1.0;
        result = instance.divisjon(x, y);
        assertEquals(expResult, result, delta);  // test 1
    }

    @Test(expected=ArithmeticException.class)
    public void testDiv(){
		System.out.println("testDiv (int)");
		instance.div(1,0);

    }

	@Test(timeout=1000)  // Hva skjer om du endrer denne til 100?
	public void tidsbegr(){
		System.out.println("tidsbegr");
		int i = 0;
		for(i=0; i<Integer.MAX_VALUE; i++);
		assertTrue("Likhet" ,i==Integer.MAX_VALUE);
	}

	@Ignore("uferdig test - blir ikke tatt med som i testkjoringen")
	@Test
    public void testNoe(){
		//System.out.println("ignore");
		assertEquals("hei", "hEi");
	}

    public static void main(String args[]) {
	      org.junit.runner.JUnitCore.main(KalkisTest.class.getName()); // tas med dersom textpad ikke er konfigurert
    }
}

/* Kjoring av programmet:  (E = Exception, I = Ignore)
JUnit version 4.8.1
.pluss
.minus
.gange
.divisjon
.testDiv (int)
.tidsbegr
EI
Time: 1,013
There was 1 failure:
1) tidsbegr(KalkisTest)
java.lang.Exception: test timed out after 1000 milliseconds


*/