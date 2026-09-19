import java.lang.Math;
class ModArrDiv {
	public static void main(String[] args) {
		int inArr[] = { 10, 5, 7, 12, 15, 20 };
		int n = 5;
		int divArr[] = new int[inArr.length];
		int j = 0;
		for (int i = 0; i < inArr.length; i++) {
			if (inArr[i] % n == 0) {
				divArr[j++] = inArr[i];
			}
		}
		int t1 = j;
		j = 0;
		int inDivArr[] = new int[inArr.length];
		for (int i = 0; i < inArr.length; i++) {
			if (inArr[i] % n != 0) {
				inDivArr[j++] = Math.abs(inArr[i] - inArr[(i + 1) % inArr.length]);
			}
		}
		int t2 = j;
		int outArr[] = new int[inArr.length];
		for (int i = 0; i < t1; i++) {
			outArr[i] = divArr[i];
		}
		for (int i = 0; i < t2; i++) {
			outArr[i + t1] = inDivArr[i] * n;
		}
		for (int i = 0; i < outArr.length; i++) {
			System.out.print(outArr[i] + " ");
		}
	}
}
