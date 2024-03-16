import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface manager = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		manager = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		manager = null;
	}

	/**
	 * Test for add() method
	 */
	@Test
	public void testAdd() {
		try{
			manager.add("CMSC204", 301633, 4, "SW232", "John Doe");
			manager.add("CMSC207", 21352, 4, "SW232", "Jay");
		} catch (Exception e){
			fail("No exception should occur");
		}
	}

	/**
	 * Test for get() method
	 */
	@Test
	public void testGet() {
		manager.add("CMSC204", 30163, 4, "SW232", "John Doe");
		manager.add("CMSC207", 21352, 4, "SW232", "Jay");

		try {
			assertEquals(String.format(CourseDBElement.COURSE_AS_STRING, "CMSC204", 30163, 4, "John Doe", "SW232"), manager.get(30163).toString());
			assertEquals(String.format(CourseDBElement.COURSE_AS_STRING, "CMSC207", 21352, 4, "Jay", "SW232"), manager.get(21352).toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * Test for readFile() method
	 */
	@Test
	public void testReadFile() {
		try{
			File file = new File("StudentTest.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write("CMSC204 30163 4 SW232 John Doe");
			writer.write("\nCMSC207 21352 4 SW232 Jay");
			writer.close();

			manager.readFile(file);

			assertEquals("CMSC204", manager.get(30163).getID());
			assertEquals("CMSC207", manager.get(21352).getID());
		} catch(Exception e){
			fail("No exception should be thrown.");
		}

	}

	/**
	 * Test for showAll() method
	 */
	@Test
	public void testShowAll() {
		manager.add("CMSC204", 30163, 4, "SW232", "John Doe");
		manager.add("CMSC207", 21352, 4, "SW232", "Jay");

		ArrayList<String> list = manager.showAll();

		assertEquals(String.format(CourseDBElement.COURSE_AS_STRING, "CMSC204", 30163, 4, "John Doe", "SW232"), list.get(0));
		assertEquals(String.format(CourseDBElement.COURSE_AS_STRING, "CMSC207", 21352, 4, "Jay", "SW232"), list.get(1));
	}
}