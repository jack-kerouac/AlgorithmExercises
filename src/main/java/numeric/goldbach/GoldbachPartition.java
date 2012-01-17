package numeric.goldbach;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Preconditions;

public class GoldbachPartition {

	private final long first;

	private final long second;

	public GoldbachPartition(long first, long second) {
		// TODO: check: is prime

		Preconditions.checkArgument(first <= second, "first number should be smaller or equal to second");
		this.first = first;
		this.second = second;
	}

	public GoldbachPartition(String partition) {
		Pattern p = Pattern.compile("(\\d+)\\s*\\+\\s*(\\d+)");
		Matcher m = p.matcher(partition);
		if (!m.matches())
			throw new RuntimeException(partition + " is in the wrong format for a Goldbach partition");

		// TODO: check: is prime

		first = Long.valueOf(m.group(1));
		second = Long.valueOf(m.group(2));
	}

	public long getFirst() {
		return first;
	}

	public long getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return first + " + " + second;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (first ^ (first >>> 32));
		result = prime * result + (int) (second ^ (second >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoldbachPartition other = (GoldbachPartition) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
		return true;
	}

}
