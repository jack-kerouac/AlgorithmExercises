package string;

public class StringReverser {

	public static void main(String[] args) {
		reverseRec("Hallo Welt");
	}

	private static void reverseRec(String string) {
		char[] chars = string.toCharArray();
		reverseRec(chars, 0, string.length() - 1);
		System.out.println(chars);
	}

	private static void reverseRec(char[] string, int first, int last) {
		if(last - first <= 0)
			return;
		char tmp = string[first];
		string[first] = string[last];
		string[last] = tmp;
		reverseRec(string, first+1, last-1);

	}
}
