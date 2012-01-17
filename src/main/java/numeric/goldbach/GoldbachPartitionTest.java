package numeric.goldbach;

import static org.junit.Assert.*;

import org.junit.Test;

public class GoldbachPartitionTest {

	@Test
	public void testStringConstruct_RTT() {
		GoldbachPartition gp = new GoldbachPartition(5, 15);
		assertEquals(gp, new GoldbachPartition(gp.toString()));
	}
	
	@Test
	public void testStringConstruct_NoWhitespace() {
		GoldbachPartition gp = new GoldbachPartition(5, 15);
		assertEquals(gp, new GoldbachPartition("5+15"));
	}
	
	@Test
	public void testStringConstruct_MoreWhitespace() {
		GoldbachPartition gp = new GoldbachPartition(5, 15);
		assertEquals(gp, new GoldbachPartition("5   + 	15"));
	}

}
