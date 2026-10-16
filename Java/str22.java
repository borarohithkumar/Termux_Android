class Email {
	public static void main(String args[]) {
		String fName = "Christopher";
		String lName = "Colombus";
		String key = "89";
		StringBuilder outStr = new StringBuilder();
		if (fName.length() < 5 || lName.length() < 5 || key == null || fName.length() == lName.length()) {
			System.out.println("Invalid");
			return;
		}
		for (int i = 0; i < 4; i++) {
			outStr.append(Character.toLowerCase(fName.charAt(i)));
		}
		outStr.append(".");
		for (int i = lName.length() - 3; i < lName.length(); i++) {
			outStr.append(Character.toLowerCase(lName.charAt(i)));
		}
		outStr.append(key).append("@swiftfood.com");
		System.out.println(outStr.toString());
	}
}
