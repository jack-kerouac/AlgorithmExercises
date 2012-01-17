package fastexp;

public class FastExp {

	public static void main(String[] args) {
		long a = 5;
		long p = 20;
		
		FastExp f = new FastExp();
		long result = f.fastExp(a, p);
		System.out.println(result);
		
		org.junit.Assert.assertEquals((long)Math.pow(a, p), result);
	}
	
	public long fastExp(long a, long p) {
	    if(p == 0)
	        return 1;
	    if(p % 2 == 0) {
	        // even
	        long tmp = fastExp(a, p/2);
	        return tmp * tmp;
	    }
	    else {
	    	// odd
	    	long tmp = fastExp(a, p/2);
	        return a * tmp * tmp;
	    }
	}
	
}
