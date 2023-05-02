import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DayTest_STUDENT {
	Day s1,s2,s3,s4,s5,s6,s7;
	Day[] days;
	
	@Before
	public void setUp() throws Exception {
		s1=Day.MONDAY;
		s2=Day.TUESDAY;
		s3=Day.WEDNESDAY;
		s4=Day.THURSDAY;
		s5=Day.FRIDAY;
		s6=Day.SATURDAY;
		s7=Day.SUNDAY;
		Day[] days = Day.values();
	}

	@After
	public void tearDown() throws Exception {
		s1=s2=s3=s4=s5=s6=s7=null;
		days = null;
	}

	@Test
	public void testValues() {
		days = Day.values();
		try {
			assertEquals(days[0], s1);
			assertEquals(days[1], s2);
			assertEquals(days[2], s3);
			assertEquals(days[3], s4);
			assertEquals(days[4], s5);
			assertEquals(days[5], s6);
			assertEquals(days[6], s7);
			
		} catch (Exception e) {
			fail("Out of bounds. Array came out too small.");
		}
	}
	
}
