class DigRoot {
	public static void main(String[] args) {
		int inArrA[] = {1, 5, 2, 6};
		int inArrB[] = {7, 4, 1, 4};
		int sumArr[] = new int[inArrA.length];
		int outArr[] = new int[sumArr.length];
		for (int i = 0; i < inArrA.length; i++) {
			sumArr[i] = inArrA[i] + inArrB[i];
			if (((sumArr[i] - 1) % 9 + 1) == 1) {
				outArr[i] = sumArr[i];
			}
			else {
				outArr[i] = 9;
			}
		}
		for (int i : outArr) {
			System.out.println(i);
		}
	}
}
