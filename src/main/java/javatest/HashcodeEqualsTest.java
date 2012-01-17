package javatest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class HashcodeEqualsTest {

	class Dummy {
		private final int n;

		public Dummy(int n) {
			super();
			this.n = n;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + n;
			System.out.println("hashcode on " + n + ": " + result);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			System.out.println("equals called on " + n);
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Dummy other = (Dummy) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (n != other.n)
				return false;
			return true;
		}

		private HashcodeEqualsTest getOuterType() {
			return HashcodeEqualsTest.this;
		}

	}

	@Test
	public void testHashCode() {
		Set<Dummy> map = new HashSet<Dummy>();
		System.out.println("insert");
		map.add(new Dummy(1));
		map.add(new Dummy(2));
		
		System.out.println("contains");
		map.contains(new Dummy(1));
		map.contains(new Dummy(2));
		
		System.out.println("insert again");
		map.add(new Dummy(1));
	}

}
