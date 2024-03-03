import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradeBookTest {
	private GradeBook book1, book2;

	@Before
	public void setUp() throws Exception {
		book1 = new GradeBook(5);
		book2 = new GradeBook(5);

		book1.addScore(83.2);
		book1.addScore(90.6);

		book2.addScore(77);
		book2.addScore(92.8);
		book2.addScore(85.7);
	}

	@After
	public void tearDown() throws Exception {
		book1 = book2 = null;
	}

	@Test
	public void testAddScore() {
		//book1
		assertTrue("83.2 90.6 0.0 0.0 0.0".equals(book1.toString()));
		assertEquals(2, book1.getScoreSize());

		//book2
		assertTrue("77.0 92.8 85.7 0.0 0.0".equals(book2.toString()));
		assertEquals(3, book2.getScoreSize());
	}

	@Test
	public void testSum() {
		//book1: 83.2 + 90.6 = 173.8
		assertEquals(173.8, book1.sum(), 0);

		//book2: 77.0 + 92.8 + 85.7 = 255.5
		assertEquals(255.5, book2.sum(), 0);
	}

	@Test
	public void testMinimum() {
		assertEquals(83.2, book1.minimum(), 0);
		assertEquals(77.0, book2.minimum(), 0);
	}

	@Test
	public void testFinalScore() {
		assertEquals(90.6, book1.finalScore(), .001);
		assertEquals(178.5, book2.finalScore(), .001);
	}
}