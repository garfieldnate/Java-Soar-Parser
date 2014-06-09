package edu.umich.soar.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

import edu.umich.soar.parser.ParseException;
import edu.umich.soar.parser.SoarParser;

/**
 * Test that illegal structures throw errors and legal structures do not throw errors during the
 * parsing of Soar productions.
 * @author Nate Glenn
 *
 */
@RunWith(Parameterized.class)
public class ParseTest {
	
	// the test data is located in the following directory inside the project
	private static final String TEST_DATA_DIR = "testdata";
	
	private String testProd;
	private boolean expectSucceed;
	/**
	 * Simple constructor that saves parameter state for running each test
	 * @param testName The test name
	 * @param testProd The production to be parsed
	 * @param testXML The expected production XML structure
	 */
	public ParseTest(String testName, String testProd, Boolean expectSucceed){
		this.testProd = testProd;
		this.expectSucceed = expectSucceed;
	}

	/**
	 * Runs class setup and creates parameters for testing. Test cases are read from
	 * the test data folder. Each file should contain blocks like so:
	 * === name
	 * --- prod
	 * sp {name
	 * ...
	 * }
	 * --- success: true
	 * 
	 * Each block should contain a test name, a production and whether or not the production
	 * expected to parse.
	 * 
	 * @return The list of test parameters. Each is an array of containing the test name,
	 * the soar production and a boolean indicating whether or not the test should parse
	 * successfully..
	 * @throws IOException
	 *             if an error occurs while reading files.
	 * @throws SecurityException
	 *             if an error occurs while reading files.
	 */
	@Parameters(name = "{index}: {0}")
	public static Collection<Object[]> productions() throws SecurityException,
			IOException {
		Collection<Object[]> params = new LinkedList<Object[]>();

		// loop through the test files
		File testDir = new File(TEST_DATA_DIR);
		for (File f : testDir.listFiles()) {

			// check for valid info file
			if (!f.canWrite() || f.isDirectory()
					|| !f.getName().endsWith(".txt"))
				continue;

			Scanner sc = new Scanner(f,"UTF-8");
			String line;
			String name = null;
			String prod = null;
			Boolean expectSucceed = true;

			boolean inProd = false;
			while (sc.hasNextLine()){
				line = sc.nextLine();
				if(line.startsWith("=== ")){
					// add previous test to parameters before starting next one
					if(name != null){
						params.add(new Object[]{name, prod, expectSucceed});
					}
					name = line.substring(4);
					inProd = false;
					prod = "";
					expectSucceed = false;
					continue;
				}else if(line.startsWith("--- prod")){
					inProd = true;
					continue;
				}else if(line.startsWith("--- parses: ")){
					inProd = false;
					expectSucceed = Boolean.parseBoolean(line.substring(12));
					if(expectSucceed){
						name += ": should parse";
					}else{
						name += ": should throw exception";
					}
					continue;
				}else if(inProd){
					prod += line + "\n";
				}
			}
			
			sc.close();
			if(name != null)
				params.add(new Object[]{name, prod, expectSucceed});
		}
		return params;
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void test() throws ParseException, SAXException, IOException {
		if(!expectSucceed){
			//JUnit has no way of specifying that we expect either ParseException or TokenMgrError
			exception.expect(Throwable.class);
		}
		String encoding = "UTF-8";
		//note that this conversion to an input stream is only good for small strings
		SoarParser parser = new SoarParser(new ByteArrayInputStream(testProd.getBytes(encoding)));
		parser.enable_tracing();
		parser.soarProduction();
	}

}
