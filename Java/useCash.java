class demo {
	public static void check(int ones, int fives, int amt, String expected) {
		int usedFives = 0;
		if (amt / 5 > fives) {
			usedFives = fives;
		}
		else {
			usedFives = amt / 5;
		}
		int remaining = amt - (usedFives * 5);
		if (ones >= remaining) {
			System.out.printf("Output: $1 = %d, $5 = %d | Expected: %s\n", remaining, usedFives, expected);
		}
		else {
			System.out.printf("Output: -1 | Expected: %s\n", expected);
		}
	}
	public static void main(String[] args) {
        check(10, 10, 27, "$1=2, $5=5");
        check(5, 4, 23, "$1=3, $5=4");
        check(5, 5, 0, "$1=0, $5=0");
        check(5, 5, 20, "$1=0, $5=4");
        check(5, 3, 4, "$1=4, $5=0");
        check(10, 1, 9, "$1=4, $5=1");
        check(10, 0, 7, "$1=7, $5=0");
        check(0, 5, 15, "$1=0, $5=3");
        check(2, 2, 15, "-1");
        check(2, 4, 14, "-1");
    }
}
