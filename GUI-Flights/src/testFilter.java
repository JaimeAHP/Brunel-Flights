import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class testFilter {

	@Test
	public void test() {
		Flights test = new Flights();
		String [] flights = {"Tokyo", "Paris", "01/08/2024", "02/08/2024"};
		ArrayList<String[]> output = Flights.filterFlights(flights);
		String [] expected1 = {"01/08/2024", "19:44", "11:03", "15:19", "19146.41", "0", "HND", "Tokyo", "CDG", "Paris", "TP6338", "Jet3"};
		String [] expected2 = {"02/08/2024", "13:36", "01:09", "11:33", "14437.93", "0", "CDG", "Paris", "HND", "Tokyo", "PT3442", "Easyplane"};
		ArrayList<String[]> expected3 = new ArrayList<String[]>();
		expected3.add(expected1);
		expected3.add(expected2);
		assertArrayEquals(expected3.toArray(), output.toArray());
	}

}
