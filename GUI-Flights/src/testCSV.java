import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class testCSV {

	@Test
	public void test() {
		Flights test = new Flights(); 
		ArrayList<String[]> output = Flights.getData();
		String [] sOutput = output.get(0);
		String [] expected = {"01/08/2024", "19:44", "11:03", "15:19", "19146.41", "0", "HND", "Tokyo", "CDG", "Paris", "TP6338", "Jet3"};
		assertArrayEquals(expected, sOutput);
	}

}
