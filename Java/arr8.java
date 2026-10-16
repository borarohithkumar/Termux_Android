class MvsByGen {
	static String getMvs(String genre, String[][] arr) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Movies by Genre: ");
		int count = 0;
		StringBuilder sb2 = new StringBuilder();
		sb2.append("\nThe Count of Movies by Genre: ");
		for (int i = 0; i < arr[0].length; i++) {
			if (genre.equals(arr[1][i])) {
				sb1.append(arr[0][i]).append("$");
				count++;
			}
		}
		if (count == 0) {
			sb1.append("Nothing");
			sb2.append("0");
		}
		else {
			sb1.setLength(sb1.length() - 1);
			sb2.append(count);
		}
		return sb1.toString() + sb2.toString();
	}
	public static void main(String[] args) {
		String arr[][] = {
			{ "The_Shawshank_Redemption", "The_Godfather", "The_Dark_Knight" },
			{ "Fiction", "Crime", "Crime" },
		};
		System.out.println(getMvs("Crime", arr));
	}
}
