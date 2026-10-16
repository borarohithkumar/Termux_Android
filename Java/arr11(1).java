import java.util.Set;
import java.util.HashSet;
class demo {
	public static void main(String[] args) {
		int arr[] = {1, 2, 1, 2, 1, 2, 4, 3, 3, 4, 5, 6};
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				continue;
			}
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			System.out.println(arr[i] + " has " + count);
			set.add(arr[i]);
		}
	}
}
