package bitwise;

import java.util.Random;

import static org.junit.Assert.*;

public class BitwiseStuff {

	public static void main(String[] args) {
		Random rand = new Random();

		int toRotate = rand.nextInt();
		int turns = rand.nextInt(32);
		assertEquals(Integer.rotateLeft(toRotate, turns), rotateLeft(toRotate, turns));

		int i = new Random().nextInt();
		print(i);
		System.out.println(highestBit(i));

		assertEquals(
				(int) (Math.log(Math.abs((long) Integer.highestOneBit(i))) / Math
						.log(2)), highestBit(i));
	}

	private static int highestBit(int i) {
		for (int c = 31; c >= 0; c--) {
			int bitmask = 1 << c;
			if ((i & bitmask) == bitmask)
				return c;
		}
		return -1;
	}

	private static int rotateLeft(int i, int turns) {
		int i1 = i << turns;
		int i2 = i >>> 32 - turns;

		return i1 | i2;
	}

	private static void print(int i) {
		String bit = "";
		for (int c = 0; c < Integer.numberOfLeadingZeros(i); c++) {
			bit += "0";
		}
		bit += Integer.toBinaryString(i);

		String dec = String.valueOf(i) + ": ";

		for (int c = 0; c <= 10 - Math.floor(Math.log10(Math.abs((long) i))); c++) {
			dec += " ";
		}
		if (i > 0)
			dec += " ";

		System.out.println(dec + bit);
	}
}