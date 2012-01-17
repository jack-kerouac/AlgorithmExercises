package string;

public class StringPermuter {
	public static void main(String[] args) {
		new StringPermuter().permute("ABCDEF");
	}

	public void permute(String permute) {
		permute("", permute);
	}

	private void permute(String prefix, String permute) {
		if (permute.isEmpty()) {
			System.out.println(prefix);
		}

		for (int i = 0; i < permute.length(); i++) {
			char next = permute.charAt(i);
			permute(prefix + next, removeFirstOcc(permute, next));
		}
	}

	private String removeFirstOcc(String permute, char c) {
		for (int i = 0; i < permute.length(); i++) {
			if (permute.charAt(i) == c)
				return permute.substring(0, i)
						+ permute.substring(i + 1, permute.length());
		}
		throw new RuntimeException();
	}
}
