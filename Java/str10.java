import java.util.Scanner;
class RevStr {
    static void rev(int i, int f, char arr[]) {
		char temp;
        while (i < f) {
            temp = arr[i];
            arr[i] = arr[f];
            arr[f] = temp;
            i++;
            f--;
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
        char[] arr = s.toCharArray();
        int r = 0;
        int w = 0;
        while (r < arr.length) {
            while (r < arr.length && arr[r] == ' ') {
                r++;
            }
            if (w > 0 && r < arr.length) {
                arr[w] = ' ';
                w++;
            }
            while (r < arr.length && arr[r] != ' ') {
                arr[w] = arr[r];
                w++;
                r++;
            }
        }
        rev(0, w - 1, arr);
        int st = 0;
        for (int p = 0; p < w + 1; p++) {
            if (p == w || arr[p] == ' ') {
                rev(st, p - 1, arr);
                st = p + 1;
            }
        }
		System.out.println(new String(arr, 0, w));
		sc.close();
    }
}
