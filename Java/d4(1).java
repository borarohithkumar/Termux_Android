class D4 {
	public static void main(String[] args) {
		String[] availArr = { "room", "book", "food", "drink", "key", "ball", "cat", "pencil", "parking" };
		int[] priceArr = {100, 50, 100, 150, 10, 200, 5, 20, 10};

		String[][] needArr = {
			{ "book", "food", "ball", "pencil", "NA" },
			{ "3", "10", "2", "5", "NA" }
		};

		int totalPrice = 0;
		for (int i = 0; i < needArr[0].length; i++) {
			boolean found = false;
			for (int j = 0; j < availArr.length; j++) {
				if (needArr[0][i].equals(availArr[j])) {
					found = true;
					totalPrice += Integer.parseInt(needArr[1][i]) * priceArr[j];
					break;
				}
			}
			if (!found) {
				System.out.println(totalPrice + ", but, NA!");
				return;
			}
		}
		System.out.println(totalPrice);
	}
}

// totalPrice will be:  1650
