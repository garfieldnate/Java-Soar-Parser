package edu.umich.soar.parser;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TortureTest {
	
	@Test
	public void test() throws ParseException, SAXException, IOException {
		// the test data is located in the following file inside the project
		String tortureFile = "testdata" + File.separatorChar + "torture.soar";
		//note that this conversion to an input stream is only good for small strings
		SoarParser parser = new SoarParser(new FileReader(new File(tortureFile)));
		parser.enable_tracing();
		Vector productions = parser.VisualSoarFile();
		assertEquals(productions.size(), 822);
	}

}
