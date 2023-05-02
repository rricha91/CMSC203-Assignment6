import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TypeTest_STUDENT {
	Type s1,s2,s3;
	Type[] Types;
	
	@Before
	public void setUp() throws Exception {
		s1=Type.COFFEE;
		s2=Type.SMOOTHIE;
		s3=Type.ALCOHOL;
		Type[] Types = Type.values();
	}

	@After
	public void tearDown() throws Exception {
		s1=s2=s3=null;
		Types = null;
	}

	@Test
	public void testValues() {
		Types= Type.values();
		try {
			assertEquals(Types[0], s1);
			assertEquals(Types[1], s2);
			assertEquals(Types[2], s3);
		} catch (Exception e) {
			fail("Out of bounds. Array came out too small.");
		}
	}
	
}
