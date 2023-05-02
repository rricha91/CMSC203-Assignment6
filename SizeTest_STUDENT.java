import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SizeTest_STUDENT {
	Size s1,s2,s3,s4;
	Size[] sizes;
	
	@Before
	public void setUp() throws Exception {
		s1=Size.MEDIUM;
		s2=Size.SMALL;
		s3=Size.LARGE;
		Size[] sizes = Size.values();
	}

	@After
	public void tearDown() throws Exception {
		s1=s2=s3=s4=null;
		sizes = null;
	}

	@Test
	public void testValues() {
		sizes= Size.values();
		try {
			assertEquals(sizes[0], s2);
			assertEquals(sizes[1], s1);
			assertEquals(sizes[2], s3);
		} catch (Exception e) {
			fail("Out of bounds. Array came out too small.");
		}
	}
	
}
