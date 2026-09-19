class BookRetail {
	private String[] availableBooks;
	private double[] bookPrices;
	private String[] purchasedBooks;
	private int[] purchasedQuantities;

	public BookRetail(String availableBooks[], double bookPrices[], String purchasedBooks[], int purchasedQuantities[]) {
		this.availableBooks = availableBooks;
		this.bookPrices = bookPrices;
		this.purchasedBooks = purchasedBooks;
		this.purchasedQuantities = purchasedQuantities;
	}

	public String[] getAvailableBooks() {
		return availableBooks;
	}
	public double[] getBookPrices() {
		return bookPrices;
	}
	public String[] getPurchasedBooks() {
		return purchasedBooks;
	}
	public int[] getPurchasedQuantities() {
		return purchasedQuantities;
	}

	public void setAvailableBooks(String availableBooks[]) {
		this.availableBooks = availableBooks;
	}
	public void setBookPrices(double bookPrices[]) {
		this.bookPrices = bookPrices;
	}
	public void setPurchasedBooks(String purchasedBooks[]) {
		this.purchasedBooks = purchasedBooks;
	}
	public void setPurchasedQuantities(int purchasedQuantities[]) {
		this.purchasedQuantities = purchasedQuantities;
	}
}

class BookRetailTest {
	static double calculateBill(BookRetail bookRetail) {
		double totalBill = 0.0;
		int found;
		for (int i = 0; i < bookRetail.getPurchasedBooks().length; i++) {
			found = -1;
			for (int j = 0; j < bookRetail.getAvailableBooks().length; j++) {
				if (bookRetail.getPurchasedBooks()[i].equals(bookRetail.getAvailableBooks()[j])) {
					found = j;
					break;
				}
			}
			if (found == -1) {
				return -1.0;
			}
			totalBill += bookRetail.getPurchasedQuantities()[i] * bookRetail.getBookPrices()[found];
		}
		if (totalBill > 100.0) {
			totalBill -= totalBill * 0.05;
		}
		return totalBill;
	}

	public static void main(String[] args) {
		BookRetail bookRetail = new BookRetail(new String[]{"The Lord of the Rings", "Pride and Prejudice", "To Kill a Mockingbird", "1984"}, new double[]{15.99, 12.50, 10.00, 14.00}, new String[]{"The Lord of the Rings", "To Kill a Mockingbird"}, new int[]{2, 1});
		System.out.println(calculateBill(bookRetail));
	}
}
